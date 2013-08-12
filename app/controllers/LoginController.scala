package controllers

import play.api.mvc.{Action, Controller}
import play.api.data.Forms._
import play.api.data._
import models.AdminUser

object LoginController extends Controller {

  def login = TODO
//  { implicit request =>
//    loginForm.bindFromRequest.fold(
//      errors =>
//        BadRequest(views.html.homepage.index(), errors),
//      (email, password) => {
//        val adminUser = AdminUser.authenticate(username, password)
//        Ok(views.html.admin.adminHome(adminUser))
//      }
//    )
//  }

  val loginForm = Form(
    tuple(
      "email" -> email,
      "password" -> text
    )
  )

}
