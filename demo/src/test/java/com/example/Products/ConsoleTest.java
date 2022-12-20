package com.example.Products;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConsoleTest {
    final double margin = 0.00000000001;

    @Test
    public void testConsole() {
        Console c = new Console("console", 399.99, "PS5");

        assertEquals("PS5", c.getTitle());
        assertEquals(399.99, c.getPrice(), margin);
    }

}
