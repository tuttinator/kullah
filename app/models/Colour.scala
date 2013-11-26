package models

case class Colour(id: Long, name: String, hex: String)

object Colour {
  
  import play.api.db._
  import play.api.Play.current
  import anorm._
  import anorm.SqlParser._

  val colour = {
    get[Long]("id") ~ 
    get[String]("name") ~
    get[String]("hex") map {
      case id~name~hex => Colour(id, name, hex)
    }
  }

  def all(): List[Colour] = DB.withConnection { implicit connection =>
    SQL("select * from colour").as(colour *)
  }

  def findById(id: Long) = DB.withConnection { implicit connection =>
    SQL("select * from colour where id = {id}").on(
      'id -> id
    ).as(colour *)
  }

  def findByName(name: String) = DB.withConnection { implicit connection =>
    SQL("select * from colour where name = {name} limit 1").as(colour *)
  }

  def findByHex(hex: String) = DB.withConnection { implicit connection =>
    SQL("select * from colour where hex = {hex} limit 1").as(colour *)
  }

}