name := """skillapmplifier"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"


libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.jolbox" % "bonecp" % "0.8.0.RELEASE",
  "org.postgresql" % "postgresql" % "9.3-1101-jdbc4",
  "commons-io" % "commons-io" % "2.3",
  "org.elasticsearch" % "elasticsearch" % "1.1.1",
  "org.apache.commons" % "commons-email" % "1.3.2",
  "org.apache.poi" % "poi" % "3.10-FINAL",
  "org.apache.poi" % "poi-ooxml" % "3.9",
  "joda-time" % "joda-time" % "2.3"
)     
