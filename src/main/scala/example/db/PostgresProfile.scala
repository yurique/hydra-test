package example.db

import com.github.tminglei.slickpg.PgCirceJsonSupport
import io.circe.{Json, Printer}
import io.circe.parser.parse
import slick.jdbc.JdbcType
import io.circe.syntax._

trait PostgresProfile extends slick.jdbc.PostgresProfile with PgCirceJsonSupport {

  override val pgjson = "jsonb"

  override val api: API = new API {}

  val plainAPI = new API with CirceJsonPlainImplicits

  private val jsonPrinter = Printer.spaces2.copy(dropNullValues = true)

  ///
  trait API extends super.API with JsonImplicits {
    override implicit val circeJsonTypeMapper: JdbcType[Json] =
      new GenericJdbcType[Json](
        pgjson,
        v => parse(v).getOrElse(Json.Null),
        v => v.asJson.pretty(jsonPrinter),
        hasLiteralForm = false
      )
  }
}

object PostgresProfile extends PostgresProfile
