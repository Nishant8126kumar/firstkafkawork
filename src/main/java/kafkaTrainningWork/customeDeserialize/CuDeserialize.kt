package kafkaTrainningWork.customeDeserialize

import com.fasterxml.jackson.databind.ObjectMapper
import kafkaTrainningWork.model.User
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serializer
import java.util.*

class CuDeserialize: Deserializer<Object>
{
    var mapper=ObjectMapper()
    var user:User?=null
    override fun deserialize(topic: String?, data: ByteArray?): Object {
//        TODO("Not yet implemented")
        try {

            user =mapper.readValue(data,User::class.java)


        } catch (e: Exception) {
        }
        println("useData=$user")
        return user as Object
    }
}