package kafkaTrainningWork.customSerialize

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class CuSerialize:Serializer<Any>
{
    var mapper=ObjectMapper();
    override fun serialize(topic: String?, data: Any?): ByteArray {

//        var byteData=ByteArray(50)
//        byteData=mapper.writeValueAsString()
        var byteData=mapper.writeValueAsString(data).toByteArray()
        return byteData
    }
}