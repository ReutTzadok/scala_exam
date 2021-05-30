package users.services.readFeomFiles

import users.model.Client

import scala.collection.mutable.ListBuffer

trait ReadClients {

  def read(filePath: String): ListBuffer[Client]

}
