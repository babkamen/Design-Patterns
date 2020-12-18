package com.babkamen.composite;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;

class CompositeTest {

    @Test
    void test() {
        Box mainBox = new Box();
        mainBox.add(new Product("shirt", BigDecimal.valueOf(50D)));
        Box box = new Box();
        mainBox.add(box);
        box.add(new Product("Screwdriver", BigDecimal.valueOf(100D)));
        assertThat(mainBox.getPrice(), Matchers.comparesEqualTo(BigDecimal.valueOf(150)));
    }
}
