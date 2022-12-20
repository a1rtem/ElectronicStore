package com.example.Coupons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.Products.Console;

public class GameKeyTest {

    final double TOLERANCE = 0.000001;

    @Test
    public void testGetMethods() {
        GameKey gamekey = new GameKey("gamekey", "UNO");
        Console cons = new Console("console", 300, "nintendo");
        assertEquals("gamekey", gamekey.getType());
        assertEquals("UNO", gamekey.getTitle());
        assertEquals(-300, gamekey.applyCoupon(cons), TOLERANCE);
    }
}
