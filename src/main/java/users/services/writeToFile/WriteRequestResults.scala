package users.services.writeToFile

import users.model.Request

trait WriteRequestResults {
  def write(results: String, request: Request): Unit
}
