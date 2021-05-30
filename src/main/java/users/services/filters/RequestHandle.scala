package users.services.filters

import users.model.{Person, Request, User}

trait RequestHandle {
  def filter (request: Request, users: List[User]) : Unit
}
