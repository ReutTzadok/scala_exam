package users.services.writeToFile

import users.model.{Request, User}

trait WriteRequestResults {
  def write(results: String, request: Request): Unit
}
