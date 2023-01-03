package com.example.monil.mockitodemo;

import android.test.InstrumentationTestCase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


/**
 * Created by Volansys on 28/3/18.
 */
public class OrderTest extends InstrumentationTestCase {


    public void testInStock() {
        Warehouse mockWarehouse = mock(Warehouse.class);

        when(mockWarehouse.hasInventory("computer", 50)).thenReturn(true);

        Order order = new Order("computer", 50);
        order.fill(mockWarehouse);

        assertTrue(order.isFilled());
        verify(mockWarehouse).remove("computer", 50);
    }

    public void testOutOfStock() {
        Warehouse mockWarehouse = mock(Warehouse.class);

        when(mockWarehouse.hasInventory("computer", 50)).thenReturn(false);

        Order order = new Order("computer", 50);
        order.fill(mockWarehouse);

        assertFalse(order.isFilled());
    }
}