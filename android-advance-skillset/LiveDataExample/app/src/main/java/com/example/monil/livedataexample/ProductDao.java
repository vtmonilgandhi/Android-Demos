package com.example.monil.livedataexample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Volansys on 10/4/18.
 */
@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    LiveData<List<Product>>  getAll();

    @Query("SELECT * FROM product WHERE name IN (:name)")
    List<Product> getProductByName(String name);

    @Query("SELECT * FROM product WHERE id IN (:id)")
    Product getProductById(int id);

    @Insert
    void insertProduct(Product... students);

    @Delete
    void deleteProduct(Product student);
}
