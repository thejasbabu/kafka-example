package kafkaExample;

import org.apache.flink.api.common.functions.MapFunction;

public class FlinkIteratorMapper implements MapFunction<Integer, Integer> {

    @Override
    public Integer map(Integer value) {
        return value * 10;
    }

}
