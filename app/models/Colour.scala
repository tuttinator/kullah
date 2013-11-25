package models

case class Colour(id: Long, name: String, hex: String)

object Colour {
  
  import play.api.db._
  import play.api.Play.current
  import anorm._
  import anorm.SqlParser._

  val colour = {
    get[Long]("id") ~ 
    get[String]("name") map {
      case id~name => Colour(id, name)
    }
    get[String]("hex") map {
      case id~hex => Colour(id, hex)
    }
  }

  def all(): List[Colour] = DB.withConnection { implicit c =>
    SQL("select * from colour").as(colour *)
  }
  
  def find_by_id(id: Long) {
    SQL("select * from colour where id = {id} limit 1").as(colour *)
  }

  def find_by_name(name: String) {
    SQL("select * from colour where name = {name} limit 1").as(colour *)
  }

  def find_by_hex(hex: String) {
    SQL("select * from colour where hex = {hex} limit 1").as(colour *)
  }

}