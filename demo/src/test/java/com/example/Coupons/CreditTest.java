package com.example.Coupons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.Products.Console;

public class CreditTest {

    final double TOLERANCE = 0.000001;

    @Test
    public void testGetMethods() {
        Credit cred = new Credit("credit", 10);
        Console cons = new Console("console", 100, "nintendo");
        assertEquals("credit", cred.getType());
        assertEquals(10, cred.getAmount(), TOLERANCE);
        assertEquals(-10, cred.applyCoupon(cons), TOLERANCE);
    }
}
