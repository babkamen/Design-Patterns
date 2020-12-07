import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    public void testSingletons(){
        assert SingletonTester.isSingleton(() -> SingletonEnum.INSTANCE);
        assert SingletonTester.isSingleton(ThreadSafeLazyInitializationSingleton::getInstance);
    }
}
