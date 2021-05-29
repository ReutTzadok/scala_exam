package users.services.filters
import org.springframework.stereotype.Component
import users.model.{Request, User}
import users.services.filters.Filters.FilterUsers

@Component
class FilterManagementImpl extends FilterManagement {
  override def filter(filterRequest: Request, users: List[User]): List[User] = {
    //return users.


    users.filterByAge(filterRequest.minAge, filterRequest.maxAge)
      .filterByNamePrefix(filterRequest.prefixName)
      .filterByGender(filterRequest.gender)
      .filterByMaritalStatus(filterRequest.maritalStatus)
      .filterByNumberOfChildren(filterRequest.NumberOfChildren)
  }
}
