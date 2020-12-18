package com.babkamen.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SingletonTest {

    @Test
    void testSingletons() {
        assertTrue(SingletonTester.isSingleton(() -> SingletonEnum.INSTANCE));
        assertTrue(SingletonTester.isSingleton(ThreadSafeLazyInitializationSingleton::getInstance));
    }
}
