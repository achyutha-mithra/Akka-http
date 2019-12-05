import java.util.concurrent.Executors

import akka.{Done, actor}
import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.http.javadsl.server.Route
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.Future
import scala.concurrent.duration.Duration
import scala.io.StdIn

object AkkaHttpWithoutAsk {

  //Count variable to keep track of Hits on a particular URL
  val count = new AtomicInteger() // thread-safe programming on single variables
  final case class Inc()
  final case class fetch()
  class ActorClass extends Actor  {
 
  // Receive just performs incrementation of Count variable
    def receive = {
      case Inc =>
        count.incrementAndGet()
    }
  }


  def main(args: Array[String]) {

    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val actor1 = system.actorOf(Props[ActorClass], "SimpleActor")
    
    lazy val route =
      pathEndOrSingleSlash {
        actor1 ! Inc
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>You visited $count times</h1>"))
      }

    Http().bindAndHandle(route, "localhost", 8080)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")

    StdIn.readLine() // let it run until user presses return

    Await.result(system.whenTerminated, Duration.Inf)
  }



}
