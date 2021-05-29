package users.model

//todo make all the fields optional so there no always be filtered
case class Request(minAge:Int, maxAge:Int, gender:String, prefixName:String, maritalStatus: String, NumberOfChildren:Int)
