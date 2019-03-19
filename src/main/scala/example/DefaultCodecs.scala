package example

import io.circe.{Decoder, Encoder, Json}
import shapeless.tag
import shapeless.tag.@@

trait DefaultCodecs {

  implicit def encodeTypedString[T]: Encoder[String @@ T] =
    id => Json.fromString(id.toString)

  implicit def decodeTypedString[T]: Decoder[String @@ T] =
    Decoder.decodeString.map(tag[T][String])

}