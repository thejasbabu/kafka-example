package kafkaExample;

import org.apache.flink.api.common.functions.FilterFunction;

public class FlinkFilter implements FilterFunction<Integer> {
    @Override
    public boolean filter(Integer value){
        return value < 50;
    }
}
