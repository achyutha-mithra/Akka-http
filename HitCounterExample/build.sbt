name := "show-tix"

version := "0.1"

scalaVersion := "2.12.6"

organization := "com.showtix"

libraryDependencies ++= {
  val akkaVersion = "2.5.12"
  val akkaHttp = "10.1.1"

  resolvers += "confluent" at "http://packages.confluent.io/maven/"

  Seq(
    "com.typesafe.akka" %% "akka-actor"      % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core"  % akkaHttp,
    "com.typesafe.akka" %% "akka-http"       % akkaHttp,
    "com.typesafe.play" %% "play-ws-standalone-json"       % "1.1.8",
    "com.typesafe.akka" %% "akka-slf4j"      % akkaVersion,
    "ch.qos.logback"    %  "logback-classic" % "1.2.3",
    "de.heikoseeberger" %% "akka-http-play-json"   % "1.17.0",
    "com.typesafe.akka" %% "akka-testkit"    % akkaVersion   % "test",
    "org.scalatest"     %% "scalatest"       % "3.0.5"       % "test",
   "org.apache.avro"  %  "avro"  %  "1.7.7",
    "org.scala-js" %%% "scalajs-dom" % "0.9.1",
    "com.lihaoyi" %%% "utest" % "0.4.5" % "test",
    "net.liftweb"       %% "lift-webkit" % "3.3.0" % "compile",
    "ch.qos.logback" % "logback-classic" % "1.2.3"

  )
}
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.24"
libraryDependencies += "org.apache.kafka" %% "kafka" % "2.1.0"


enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true




