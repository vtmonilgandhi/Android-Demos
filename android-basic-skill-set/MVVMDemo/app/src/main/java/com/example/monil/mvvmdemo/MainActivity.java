package com.example.monil.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import com.example.monil.mvvmdemo.databinding.ProductDetails;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        ProductDetails binding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);

        ProductViewModel viewModel = new ProductViewModel(this);
        binding.setProducts(viewModel);
    }
}
