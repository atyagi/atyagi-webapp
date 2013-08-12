package models

import anorm._
import play.api.db.DB
import play.api.data.Forms._
import play.api.data._
import play.api.Play.current
import play.api.libs.Crypto

case class AdminUser(username: String, password: String)

object AdminUser {

  val connection = DB.getConnection("default")

  def authQuery(username: String, password: String): Sql = SQL(
    "SELECT * " +
    "FROM admin_user " +
    "WHERE username = {username} " +
      "AND password = {password}")
        .on(
          "username" -> username
          ,"password" -> password
      )

  def authenticate(username: String, password: String): AdminUser = {
      val signedPass = Crypto.sign(username.concat(password))
      val adminUser = authQuery(username, signedPass).
        apply()(connection)
      adminUser.asInstanceOf[AdminUser]
  }

}
