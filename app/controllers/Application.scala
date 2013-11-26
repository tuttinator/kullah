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
    Ok(Json.toJson(Colour.all))
  }

  def colour(id: Long) = Action {
    Ok(views.html.index("yo"))
  }

}

