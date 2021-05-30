package users.services.readFeomFiles

import users.model.Request

trait ReadRequest {
  def read(filePath: String): List[Request]
}
