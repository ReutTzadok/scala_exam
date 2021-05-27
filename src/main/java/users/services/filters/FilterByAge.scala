package users.services.filters
import users.model.Person

//todo writing this method as a List[Person] method. should I create a dataset model? implicit can help hear?
trait FilterByAge{
  def filter(people: List[Person], minAge: Int, maxAge:Int): List[Person]
}
