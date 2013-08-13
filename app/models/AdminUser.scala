package models

import play.api.db.slick.Config.driver.simple._
import play.api.libs.Crypto

object AdminUser extends Table[(Long, String, String, String, String)]("admin_users"){
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def email = column[String]("email_address")
  def password = column[String]("password")
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")

  def * = id ~ email ~ password ~ firstName ~ lastName

  /******************* Queries *********************/

  def authenticate(email: String, password: String)(implicit s:Session): Boolean = {
    val authenticate = for {
      (email, password) <- Parameters[(String, String)]
      au <- AdminUser if au.email is email && au.password is password
    } yield au.exists

    authenticate(email, hashPassword(email, password)).first
  }

  /**
   * TODO: what's the signature? case class? Want to do the hashing here for central logic
   */
  def create() = {

  }

  def hashPassword(email: String, password: String): String = Crypto.sign(password.concat(email))

}
