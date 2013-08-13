package controllers

import play.api.mvc.{Action, Controller}
import play.api.data.Forms._
import play.api.data._
import models.AdminUser

object LoginController extends Controller {

  def login = TODO

  val loginForm = Form(
    tuple(
      "email" -> email,
      "password" -> text
    )
  )

}
