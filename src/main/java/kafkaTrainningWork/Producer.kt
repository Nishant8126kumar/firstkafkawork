import kafkaTrainningWork.KafkaContant
import kafkaTrainningWork.customSerialize.CuSerialize
import kafkaTrainningWork.model.User
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import java.util.*

class Producer
{
    val const=KafkaContant()
    fun producer():KafkaProducer<String,User>
    {
        var properties=Properties()
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaContant.kakfkaBroker)
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,KafkaContant.kafkaSerializer)
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,CuSerialize::class.java)
        return KafkaProducer<String,User>(properties)
    }
}

