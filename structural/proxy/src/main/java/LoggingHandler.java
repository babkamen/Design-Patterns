import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class LoggingHandler {

    <T> T execute(Supplier<T> c) {
        Instant start = Instant.now();
        T result = null;
        try {
            result = c.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        System.out.println("Request took " + Duration.between(start, end));
        return result;
    }
}
