package com.example.Products;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoardGameTest {

    final double TOLERANCE = 0.000001;

    @Test
    public void testGetMethods() {
        BoardGame test = new BoardGame("board", 33.99, "Monopoly", "12+", 30);
        assertEquals(33.99, test.getPrice(), TOLERANCE);
        assertEquals("Monopoly", test.getTitle());
        assertEquals("12+", test.getRating());
        assertEquals(30, test.getNumberOfPieces());
    }
}