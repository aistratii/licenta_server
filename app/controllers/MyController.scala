package controllers

import javax.inject.Inject

import play.modules.reactivemongo._
import play.api.Logger

import akka.actor.ActorSystem
import play.api._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._
//import play.api.libs.json.Json 
import play.api.libs.json._


import reactivemongo.api._
import reactivemongo.play.json._
import play.modules.reactivemongo.json.collection._ 
import play.modules.reactivemongo.json.collection.JSONCollection

import reactivemongo.bson.BSONDocument
import reactivemongo.api.collections.bson.BSONCollection

import scala.util.{Failure, Success}
import mongooperations.MongoOperations
import scala.concurrent._
import models.Net



class MyController @Inject() (val reactiveMongoApi: ReactiveMongoApi)(implicit exec: ExecutionContext) 
  extends Controller with MongoOperations {  	

  	def insert = Action.async (parse.json){ implicit request =>
  		val response = Promise[String]
  		println(request.body)
		
		val update = request.body.as[JsObject]
  		val selector = Json.obj("name" -> "anamaria")
  		
		

  		collection.update(selector, update, upsert=true) onComplete {
  			case Success(_) => {
					Logger.info("inserted: " + update)
					response.success("inserted: " + update)
				}	  								
  			case Failure(e) => {
  				Logger.error("db error")
  				response.success("err")
  			}
  		}
  		Logger.info("insert called")
		response.future.map(i => Ok(i))
  	}
}