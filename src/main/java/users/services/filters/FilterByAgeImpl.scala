package users.services.filters
import org.springframework.stereotype.Component
import users.model.Person


@Component
class FilterByAgeImpl extends FilterByAge {
  override def filter(people: List[Person], minAge: Int, maxAge: Int): List[Person] = {
    people.filter(p => p.age >= minAge && p.age <= maxAge)
  }
}
