import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ThreadSafeLazyInitializationSingleton {
    private final String content = "lorem ipsum";

    private static class Holder {
        private static final ThreadSafeLazyInitializationSingleton INSTANCE = new ThreadSafeLazyInitializationSingleton();
    }

    public static ThreadSafeLazyInitializationSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
