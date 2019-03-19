package example

case class User(id: User.Id)

object User extends TypedId[User] with DefaultCodecs