package example

import db.api._

class UserTable(tag: Tag) extends CustomTable[User](tag, "user") {

  def id = column[User.Id]("id", O.PrimaryKey)

  def * = id <> (User.apply _, User.unapply)

}
