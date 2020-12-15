import kafka.Kafka
import kafka.tools.ConsoleProducer
import kafkaTrainningWork.KafkaContant
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import java.util.*

class Producer
{
    val const=KafkaContant()
    fun producer():KafkaProducer<String,String>
    {
        var properties=Properties()
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,const.kakfkaBroker)
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,const.kafkaSerializer)
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,const.kafkaSerializer)
        return KafkaProducer<String,String>(properties)
    }
}

