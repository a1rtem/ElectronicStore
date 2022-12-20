package com.example.Products;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest {

    final double TOLERANCE = 0.000001;

    @Test
    public void testGetMethods() {
        Game test = new Game("game", 33.99, "Dungeons & Dragons", "12+");
        assertEquals(33.99, test.getPrice(), TOLERANCE);
        assertEquals("Dungeons & Dragons", test.getTitle());
        assertEquals("12+", test.getRating());
    }
}