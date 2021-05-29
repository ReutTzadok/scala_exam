package users.services.filters

import users.model.{Person, Request, User}

trait FilterManagement {
  def filter (filterRequest: Request, users: List[User]) : List[User]
}
