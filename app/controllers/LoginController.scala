package controllers

import play.api.mvc.{Action, Controller}
import play.api.data.Forms._
import play.api.data._
import play.api.Play.current
import models.AdminUser
import play.api.db.DB
import scala.slick.jdbc.meta.MBestRowIdentifierColumn.Scope.Session

object LoginController extends Controller {

  def login = Action { implicit request =>
    loginForm.bindFromRequest.fold(
      formWithErrors => BadRequest(),
      adminUser => Ok(views.admin.adminHome())
    )
  }

  val loginForm = Form(
    tuple(
      "email" -> email,
      "password" -> text
    ) verifying("Email/Password not valid", result => result match {
      case (email, password) => AdminUser.authenticate(email, password)
    })
  )



}
