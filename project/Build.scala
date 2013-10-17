import sbt._
import Keys._
import play.Project._

import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "play-jdbc-driver-bug"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    javaCore,
    javaJdbc,
    javaEbean,
    "commons-beanutils" % "commons-beanutils" % "1.8.3",
    "commons-collections" % "commons-collections" % "3.2.1",
    "commons-validator" % "commons-validator" % "1.4.0",
    "org.springframework" % "spring-jdbc" % "3.1.2.RELEASE",
    "mysql" % "mysql-connector-java" % "5.1.6"     
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    resolvers += "SpringSource repository" at "http://repo.springsource.org/release"
   
  )

}
