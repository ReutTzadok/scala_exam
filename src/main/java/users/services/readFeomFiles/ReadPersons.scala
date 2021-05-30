package users.services.readFeomFiles

import users.model.{Person}

import scala.collection.mutable.ListBuffer

trait ReadPersons {

  def read(filePath: String): ListBuffer[Person]
}
