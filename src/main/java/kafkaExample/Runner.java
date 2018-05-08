package kafkaExample;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        if (args[0].equals("producer")) {
            Producer.main(args);
        } else if (args[0].equals("consumer")) {
            Consumer.main(args);
        } else {
            throw new IllegalArgumentException("Don't know how to do " + args[0]);
        }
    }
}
