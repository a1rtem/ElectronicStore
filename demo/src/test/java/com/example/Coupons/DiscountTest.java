package com.example.Coupons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.Products.Console;

public class DiscountTest {

    final double TOLERANCE = 0.000001;

    @Test
    public void testGetMethods() {
        Discount disc = new Discount("discount", 20, "nintendo");
        Console cons = new Console("console", 200, "nintendo");
        assertEquals("discount", disc.getType());
        assertEquals(20, disc.getPercentage(), TOLERANCE);
        assertEquals("nintendo", disc.getTitle());
        assertEquals(-40, disc.applyCoupon(cons), TOLERANCE);
    }
}
