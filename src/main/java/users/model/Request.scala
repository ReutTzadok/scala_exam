package users.model

case class Request(min_age:String = "0", max_age:String = "0", gender:String = "", prefix_name:String = "",
                   marital_Status: String = "", number_of_Children:String = "0")
