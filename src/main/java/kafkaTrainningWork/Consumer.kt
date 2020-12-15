package kafkaTrainningWork


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.*

class Consumer {
    var const=KafkaContant();
    var properties=Properties();
    fun consumer():KafkaConsumer<String,String>
    {
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,const.kakfkaBroker)
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,const.kafkaDeserializer)
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,const.kafkaDeserializer)
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,const.kafkaGroupId)
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false)
        var kafkaConsumer=KafkaConsumer<String,String>(properties)
        var list= mutableListOf<String>()
        list.add(const.kafkaTopic)
        kafkaConsumer.subscribe(list)
        
        return kafkaConsumer
    }
}