package example

import shapeless.tag
import tag.@@

trait TypedId[T] {

  type Id = String @@ T

  object Id {
    def apply(uuid: String): Id = tag[T][String](uuid)
  }

}
