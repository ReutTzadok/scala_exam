package users.services.filters

import users.model.User

object Filters {
  implicit class FilterUsers(users: List[User]) {
    def filterByAge(minAge: Int, maxAge: Int): List[User] = {
      if (minAge == 0 || maxAge == 0)
        users
      else
        users.filter(user => (user.age >= minAge && user.age <= maxAge))
    }

    //------------------------------------------------------------------

    def filterByNamePrefix(prefix: String): List[User] = {
      if (prefix == "")
        users
      else
        users.filter(user => user.name.startsWith(prefix))
    }

    //------------------------------------------------------------------

    def filterByMaritalStatus(maritalStatus: String): List[User] = {
      if (maritalStatus == "")
        users
      else
        users.filter(user => user.maritalStatus.equalsIgnoreCase(maritalStatus))
    }

    //------------------------------------------------------------------

    def filterByNumberOfChildren(numberOfChildren: Int): List[User] = {
      if (numberOfChildren == 0)
        users
      else
        users.filter(user => user.numberOfChildren == numberOfChildren)
    }

    //------------------------------------------------------------------

    def filterByGender(gender: String): List[User] = {
      if (gender == "")
        users
      else
        users.filter(user => user.gender.equalsIgnoreCase(gender))
    }
  }
}
