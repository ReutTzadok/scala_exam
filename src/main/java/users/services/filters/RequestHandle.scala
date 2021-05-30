package users.services.filters

import users.model.{Request, User}

trait RequestHandle {
  def filter (request: Request, users: List[User]) : Unit
}
