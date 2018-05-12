package kafkaExample;

import org.apache.flink.api.common.functions.MapFunction;

public class FlinkMapper implements MapFunction<String, String> {
    @Override
    public String map(String s) throws Exception {
        System.out.println(s.concat(": Flink Appender"));
        return s.concat(": Flink Appender");
    }
}
