package users.services.readFeomFiles

import users.model.Client

import scala.collection.mutable.ListBuffer

//todo
trait ReadClients {

  def read(filePath: String): ListBuffer[Client]

}
