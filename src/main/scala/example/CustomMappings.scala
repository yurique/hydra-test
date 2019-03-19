package example

import db.api._
import io.circe.{Decoder, Encoder, Json}
import io.circe.syntax._
import shapeless.tag
import shapeless.tag.@@
import scala.reflect.ClassTag

trait CustomMappings {

  implicit def typedIntType[T]: BaseColumnType[Int @@ T] =
    MappedColumnType.base[Int @@ T, Int](identity, id => tag[T][Int](id))

  implicit def typedLongType[T]: BaseColumnType[Long @@ T] =
    MappedColumnType.base[Long @@ T, Long](identity, id => tag[T][Long](id))

  implicit def typedStringType[T]: BaseColumnType[String @@ T] =
    MappedColumnType.base[String @@ T, String](identity, id => tag[T][String](id))

  def jsonMapping[E: Decoder: Encoder: ClassTag]: BaseColumnType[E] =
    MappedColumnType.base[E, Json](
      e => e.asJson,
      s => s.as[E].getOrElseThrow
    )

  implicit class EitherThrowableOps[R, T <: Throwable](in: Either[T, R]) {
    def getOrElseThrow: R = in match {
      case Left(error)  => throw error
      case Right(value) => value
    }
  }
}
