package com.example.monil.livedataexample;

import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText mINumberEditText, mINameEditText, mIquantityEditText;
    private ListView dataLv;
    private Button mInsertButton;
    private ArrayList<String> productsList;
    private ArrayAdapter<String> adapter;

    private AppDatabase mDatabase;

    private List<Product> mproductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"product-db")
                .allowMainThreadQueries()
                .build();


        mINumberEditText = findViewById(R.id.editText_enroll);
        mINameEditText = findViewById(R.id.editText_name);
        mIquantityEditText = findViewById(R.id.editText_quantity);
        dataLv = findViewById(R.id.dataLv);
        mInsertButton = findViewById(R.id.button_insert);

        final Observer<List<Product>> nameObserver = new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable final List<Product> products) {
                mproductList = products;
                productsList = new ArrayList<>();
                adapter = new ArrayAdapter<String>(MainActivity.this,
                        R.layout.support_simple_spinner_dropdown_item, productsList);
                for (Product product : products)
                    productsList.add("Id : " + product.getId() +
                            "\nName : " + product.getName() +
                            "\nQuantity : " + product.getQuantity());
                dataLv.setAdapter(adapter);
            }
        };


        mDatabase.productDao().getAll().observe(MainActivity.this, nameObserver);
        mInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product();
                product.setId(Integer.parseInt(mINumberEditText.getText().toString()));
                product.setName(mINameEditText.getText().toString());
                product.setQuantity(mIquantityEditText.getText().toString());
                mDatabase.productDao().insertProduct(product);
            }
        });

    }
}
