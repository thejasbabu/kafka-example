package kafkaExample;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.IterativeStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

public class FlinkIterator {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> data = env.fromCollection(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        IterativeStream<Integer> iterator = data.iterate();
        SingleOutputStreamOperator<Integer> body = iterator.map(new FlinkIteratorMapper()).setParallelism(1);
        SingleOutputStreamOperator<Integer> filterFunction = body.filter(new FlinkFilter()).setParallelism(1);
        DataStream<Integer> output = iterator.closeWith(filterFunction);
        output.print();
        env.execute();
    }
}
