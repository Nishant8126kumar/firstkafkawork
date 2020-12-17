package kafkaTrainningWork

import Producer
import kafkaTrainningWork.model.User
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.concurrent.TimeUnit


class MainKafkaTask {


    fun producerWork()
    {
        println("Producer is  Running State")
        var producerObj =Producer()
        var producer=producerObj.producer()
        try {
            var s= producer.send(ProducerRecord(KafkaContant.kafkaTopic,getdetails()))
            var record=s.get(5000,TimeUnit.MINUTES)
            println(record.offset())
            println(record.partition())
            println(record.topic())

        }
        catch (e:Exception)
        {
            println("Some Exception Are Ocuured in Producer =$e")
        }
        finally {
            producer.flush()
            producer.close()
        }
    }

    fun consumerWork()
    {
        println("Consumer is Running State")
        var consumerObj=Consumer()
        var consumer=consumerObj.consumer()
        try {
            while (true)
            {
                var consumRecords=consumer.poll(100)
//                println("data=:$consumRecords")
               for (i in consumRecords)
               {

                   println("data=:$i")
//                   println("offset = %d, key = %s, value = %s\n", i.offset(), i.key(), i.value());
//                   println("offset=${i.offset()},key=${i.key()},value=${i.value()}")
               }
            }
        }
        catch (e:Exception)
        {
            println("Some Exception Are occured in consumer work=:$e")
        }
        finally {
            consumer.close()
        }
    }
    fun getdetails(): User
    {
        return User(21,"Ankit Sharma")
    }
}
fun main()
{
    var m1=MainKafkaTask()
//    Thread()
//    {
//       m1.producerWork()
//    }.start()

//    m1.producerWork()
//    m1.consumerWork()
    Thread() {
       m1.consumerWork()
    }.start()
}


