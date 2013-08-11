package controllers

import play.api.mvc.{Action, Controller}
import play.api.data.Forms._
import play.api.data._

object LoginController extends Controller {

  def login = Action {
    Ok(views.html.admin.adminHome())
  }

}
