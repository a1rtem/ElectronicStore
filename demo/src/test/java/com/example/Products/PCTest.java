package com.example.Products;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PCTest {
    final double margin = 0.00000001;

    @Test
    public void TestPC() {
        PC computer = new PC("pc", 10.99, "computer", 1000, 16);
        assertEquals("computer", computer.getTitle());
        assertEquals(10.99, computer.getPrice(), margin);
        assertEquals(1000, computer.getStorage(), margin);
        assertEquals(16, computer.getRam(), margin);
    }
}
