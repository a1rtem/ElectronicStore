package com.example.Products;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DiskGameTest {

    final double TOLERANCE = 0.000001;

    @Test
    public void testGetMethods() {
        DiskGame test = new DiskGame("disk", 33.99, "Minecraft", "12+", "XBOX", "Mojang");
        assertEquals(33.99, test.getPrice(), TOLERANCE);
        assertEquals("Minecraft", test.getTitle());
        assertEquals("12+", test.getRating());
        assertEquals("XBOX", test.getPlatform());
        assertEquals("Mojang", test.getPublisher());
    }
}