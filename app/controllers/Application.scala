package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.colours)
  }


  def colours = Action {
    Ok(
      Json.obj(
        "users" -> Json.arr(
          Json.obj(
            "name" -> "Bob",
            "age" -> 31,
            "email" -> "bob@gmail.com"
          ),
          Json.obj(
            "name" -> "Kiki",
            "age" -> 25,
            "email" -> JsNull
          )
        )
      )
    )
  }

  def colour(id: Long) = Action {
    Ok(views.html.index("yo"))
  }

}

