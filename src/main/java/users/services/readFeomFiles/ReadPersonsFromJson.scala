package users.services.readFeomFiles

import users.model.{Person}

import scala.collection.mutable.ListBuffer

trait ReadPersonsFromJson {

  def read(filePath: String): ListBuffer[Person]
}
