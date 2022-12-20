package com.example.Products;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DigitalCopyTest {

    final double TOLERANCE = 0.000001;

    @Test
    public void testGetMethods() {
        DigitalCopy test = new DigitalCopy("digital", 33.99, "Terraria", "12+", "Windows", 600);
        assertEquals(33.99, test.getPrice(), TOLERANCE);
        assertEquals("Terraria", test.getTitle());
        assertEquals("12+", test.getRating());
        assertEquals("Windows", test.getPlatform());
        assertEquals(600, test.getSize(), TOLERANCE);

    }
}