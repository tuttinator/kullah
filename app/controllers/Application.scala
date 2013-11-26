package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import models.Colour

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.colours)
  }


  def colours = Action {
    Ok(Json.toJson(Colour.all.map( implicit c =>
          Json.obj(
          "id" -> Json.toJson(c.id),
          "name" -> Json.toJson(c.name),
          "hex" -> Json.toJson(c.hex)
          )
        )
      )
    )
  }

  def colour(hex: String) = Action {
    val colour = Colour.findByHex(hex)
    Ok(Json.obj(
      "id" -> Json.toJson(colour.id),
      "name" -> Json.toJson(colour.name),
      "hex" -> Json.toJson(colour.hex)
      )
    )
  }

}