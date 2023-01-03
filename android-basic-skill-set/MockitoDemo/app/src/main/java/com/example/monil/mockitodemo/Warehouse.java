package com.example.monil.mockitodemo;

/**
 * Created by Volansys on 28/3/18.
 */
public interface Warehouse {
    boolean hasInventory(String product, int quantity);
    void remove(String product, int quantity);
}