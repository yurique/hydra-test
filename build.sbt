import Dependencies._

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

scalacOptions in ThisBuild := Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-Ypartial-unification",
    "-Yrangepos",
    "-language:postfixOps",
    "-Xcheckinit",
    "-encoding",
    "utf8"
)


lazy val root = (project in file("."))
  .settings(
    name := "hydra-test",
    libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.0",
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3",
    libraryDependencies += "com.github.tminglei" %% "slick-pg" % "0.17.2",
    libraryDependencies += "com.github.tminglei" %% "slick-pg_circe-json" % "0.17.2"
  )
