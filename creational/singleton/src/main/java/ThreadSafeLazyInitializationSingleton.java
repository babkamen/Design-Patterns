import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ThreadSafeLazyInitializationSingleton {

    private final String content = "lorem ipsum";

    public static ThreadSafeLazyInitializationSingleton getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {

        private static final ThreadSafeLazyInitializationSingleton INSTANCE = new ThreadSafeLazyInitializationSingleton();
    }
}
