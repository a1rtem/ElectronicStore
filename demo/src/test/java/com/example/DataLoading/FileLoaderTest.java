package com.example.DataLoading;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileLoaderTest {

    final double TOLERANCE = 0.000001;

    @Test
    public void testDataLoadingMethods() {
        DataLoader dl = new FileLoader("..\\file_data.txt");
        assertEquals("Chess", dl.loadProductData().get(0).getTitle());
        assertEquals("discount", dl.loadCouponData().get(0).getType());

    }
}