package models

import play.api.libs.json.Json 
import play.api.libs.json._
import reactivemongo.bson._
import reactivemongo.play.json._
import play.modules.reactivemongo.json.collection._ 
import play.modules.reactivemongo.json.collection.JSONCollection

case class Net(name:String)

object Net{
	implicit val netFormat = Json.format[Net]
}