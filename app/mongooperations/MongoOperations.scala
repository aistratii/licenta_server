package mongooperations

import javax.inject.Inject

import play.modules.reactivemongo._
import play.api.Logger

import akka.actor.ActorSystem
import play.api._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._
import play.api.libs.json.Json 
import play.api.libs.json._
import reactivemongo.play.json._
import play.modules.reactivemongo.json.collection._ 
import play.modules.reactivemongo.json.collection.JSONCollection
import scala.util.{Failure, Success}
import mongooperations.MongoOperations


trait MongoOperations extends MongoController with ReactiveMongoComponents {
	def collection: JSONCollection = db.collection[JSONCollection]("netdb_2")
}