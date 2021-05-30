package users.services.readFeomFiles

import users.model.Request

import scala.collection.mutable.ListBuffer

trait ReadRequest {
  def read(filePath: String): List[Request]
}
