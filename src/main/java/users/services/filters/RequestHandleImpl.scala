package users.services.filters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import users.model.{Request, User}
import users.services.filters.Filters.FilterUsers
import users.services.writeToFile.WriteRequestResults

@Component
class RequestHandleImpl extends RequestHandle {

  @Autowired
  val writeResults: WriteRequestResults = null

  override def filter(request: Request, users: List[User]): Unit = {

    //todo move to new class
    val result = users.filterByAge(request.min_age.toInt, request.max_age.toInt)
      .filterByNamePrefix(request.prefix_name)
      .filterByGender(request.gender)
      .filterByMaritalStatus(request.marital_Status)
      .filterByNumberOfChildren(request.number_of_Children.toInt)
      .map(user => user.toString+"\n")
      .toString()

    writeResults.write(result, request)
  }
}
