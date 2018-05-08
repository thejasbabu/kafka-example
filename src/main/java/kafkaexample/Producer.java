package kafkaExample;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 1000; i++) {
            ProducerRecord<String, String> data;
            if (i % 2 == 0) {
                data = new ProducerRecord<String, String>("even1", 0, Integer.toString(i), String.format("%d is even", i));
            } else {
                data = new ProducerRecord<String, String>("odd1", 0, Integer.toString(i), String.format("%d is odd", i));
            }
            producer.send(data);
            Thread.sleep(100L);
        }
        producer.close();
    }
}
