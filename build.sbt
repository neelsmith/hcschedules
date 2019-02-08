name := "Work with HC course schedules"

crossScalaVersions := Seq("2.11.8", "2.12.1")

resolvers += Resolver.bintrayRepo("neelsmith", "maven")
enablePlugins(TutPlugin)

name := "courses"
organization := "edu.holycross.shot"
version := "1.1.0"
licenses += ("GPL-3.0",url("https://opensource.org/licenses/gpl-3.0.html"))

libraryDependencies ++= Seq(
  "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided",
  "org.scalatest" %%% "scalatest" % "3.0.1" % "test",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
)
tutTargetDirectory := file("docs")
tutSourceDirectory := file("tut")
