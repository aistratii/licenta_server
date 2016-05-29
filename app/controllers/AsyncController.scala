package controllers

import akka.actor.ActorSystem
import javax.inject._
import play.api._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._

/**
 * This controller creates an `Action` that demonstrates how to write
 * simple asynchronous code in a controller. It uses a timer to
 * asynchronously delay sending a response for 1 second.
 *
 * @param actorSystem We need the `ActorSystem`'s `Scheduler` to
 * run code after a delay.
 * @param exec We need an `ExecutionContext` to execute our
 * asynchronous code.
 */
@Singleton
class AsyncController @Inject() (actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends Controller {

  /**
   * Create an Action that returns a plain text message after a delay
   * of 1 second.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/message`.
   */
  def message = Action.async {
    getFutureMessage(1.second).map { msg => Ok(msg) }
  }

  private def getFutureMessage(delayTime: FiniteDuration): Future[String] = {
    val promise: Promise[String] = Promise[String]()
    actorSystem.scheduler.scheduleOnce(delayTime) { promise.success("Hi!") }
    promise.future
  }





  def myexample = Action.async{
  	val futureInt = scala.concurrent.Future{ intensiveComputation }

  	/*val futureResponse : Future[Response] = futureInt;

  	futureResponse.map{response =>
  		{
  			OK("Yes, this been calculated: " + (response.json) )
  		}
  	}.recover { case _ => Ok("bla") }*/
  	futureInt.map(i => Ok("Got result: " + i))
  }


  private def intensiveComputation : Int = {
	var result: Int = 0;

  	for(i <- 1 to 1000000){
  		val sqval = 100*100/2.71*312/12312/1312321*132;
  		result = result + 1;
  	}

  	Logger.info("das result" + result)
  	result
  }

}
