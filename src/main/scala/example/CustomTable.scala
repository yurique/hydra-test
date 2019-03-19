package example

import slick.jdbc.PostgresProfile.api._

abstract class CustomTable[A](tag: Tag, _tableName: String) extends Table[A](tag, _tableName) with CustomMappings
