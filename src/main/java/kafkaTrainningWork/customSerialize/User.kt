package kafkaTrainningWork.customSerialize

import kotlin.properties.Delegates

class User {
    var age=0
    var name:String?=null
    override fun toString(): String {
        return "User(age=$age, name=$name)"
    }

}