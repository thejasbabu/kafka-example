package kafkaExample;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class FlinkConsumer {
    public static void main(String[] args) {
        List<String> topics = Arrays.asList("odd", "even");
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "flink-consumer");
        FlinkKafkaConsumer010<String> consumer = new FlinkKafkaConsumer010<>(topics, new SimpleStringSchema(), properties);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> stream = env.addSource(consumer);
        stream.map(new FlinkMapper());
        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
