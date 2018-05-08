package kafkaExample;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import java.util.Properties;

public class Stream {

    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-example");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        KStreamBuilder builder = new KStreamBuilder();
        KStream<String, String> stream = builder.stream("odd", "even");
        KStream<String, String> joined = stream
                .map((key, value) -> KeyValue.pair(key, key.concat(value)));
        joined.to("odd-even");
        KafkaStreams kafkaStreams = new KafkaStreams(builder, config);
        kafkaStreams.start();
    }
}
