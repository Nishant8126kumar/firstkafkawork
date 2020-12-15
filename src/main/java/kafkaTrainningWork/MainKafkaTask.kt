package kafkaTrainningWork

import Producer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.concurrent.TimeUnit


class MainKafkaTask {


    fun producerWork()
    {
        println("Producer is  Running State")
        var const=KafkaContant()
        var produ =Producer()
        var producer=produ.producer()
        try {
            for (i in 100..150)
            {
                println("i=:$i")
                var s=producer.send(ProducerRecord(const.kafkaTopic,i.toString(), "Test Message=$i"))
                var record=s.get(5000,TimeUnit.MINUTES)
                println(record.offset())
                print(record.partition())
                print(record.topic())
            }

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
        var consum=Consumer()
        var consumer=consum.consumer()
        try {
            while (true)
            {
                var consumRecords=consumer.poll(100)
//                println("data=:$consumRecords")
               for (i in consumRecords)
               {

//                   println("data=:$i")
//                   println("offset = %d, key = %s, value = %s\n", i.offset(), i.key(), i.value());
                   println("offset=${i.offset()},key=${i.key()},value=${i.value()}")
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
}
fun main()
{
    var m1=MainKafkaTask()
    Thread()
    {
       m1.producerWork()
    }.start()

//    m1.producerWork()
//    m1.consumerWork()
    Thread() {
       m1.consumerWork()
    }.start()
}


