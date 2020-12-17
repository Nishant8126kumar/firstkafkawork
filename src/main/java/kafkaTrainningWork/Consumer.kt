package kafkaTrainningWork


import kafkaTrainningWork.customeDeserialize.CuDeserialize
import kafkaTrainningWork.model.User
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.*

class Consumer {
//    var const=KafkaContant();
    var properties=Properties();
    fun consumer():KafkaConsumer<String,User>
    {
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaContant.kakfkaBroker)
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaContant.kafkaDeserializer)
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,CuDeserialize::class.java)
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,KafkaContant.kafkaGroupId)
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false)
        var kafkaConsumer=KafkaConsumer<String,User>(properties)
        var list= mutableListOf<String>()
        list.add(KafkaContant.kafkaTopic)
        kafkaConsumer.subscribe(list)
        
        return kafkaConsumer
    }
}