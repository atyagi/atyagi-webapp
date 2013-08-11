import sbt._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "atyagi-webapp"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    //add settings here
  )

}
