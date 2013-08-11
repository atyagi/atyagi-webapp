package models

import anorm._
import play.api.db.DB
import play.api.data.Forms._
import play.api.data._
import play.api.Play.current

class AdminUser {

  DB.withConnection { implicit c =>
    val result: Boolean = SQL("SELECT 1").execute();

  }

  def authenticate() = {

  }

  val loginForm = Form(
    tuple(
      "email" -> text,
      "password" -> text
    )
  )

}
