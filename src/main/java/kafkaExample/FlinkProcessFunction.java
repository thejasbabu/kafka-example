package kafkaExample;

import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

public class FlinkProcessFunction extends ProcessFunction<Integer, String> {
    @Override
    public void processElement(Integer value, Context context, Collector<String> collector) throws Exception {
        String valStr = value.toString();
        System.out.println("Value to string:" + valStr);
        collector.collect("Value returned by processElement: " + valStr);
    }
}
