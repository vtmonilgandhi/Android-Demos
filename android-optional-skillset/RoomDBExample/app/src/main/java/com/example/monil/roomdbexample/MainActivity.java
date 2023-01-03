package com.example.monil.roomdbexample;

import android.arch.persistence.room.Room;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.monil.roomdbexample.AppDatabase;
import com.example.monil.roomdbexample.Product;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText mINumberEditText, mINameEditText, mIquantityEditText;
    private EditText mQNumberEditText, mQNameEditText;
    private Button mInsertButton, mSearchByIdButton, mDeleteButton, mSearchByNameButton, mRetrieveAllButton;

    private AppDatabase mDatabase;

    private Product tempProduct;
    private List<Product> products;
    private String tempProductsData = "", insertMessage = "";

    final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(MainActivity.this, insertMessage, Toast.LENGTH_SHORT).show();
                    mINumberEditText.setText("");
                    mINameEditText.setText("");
                    mIquantityEditText.setText("");
                    break;

                case 1:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("product Info")
                            .setMessage("Id no.: " + tempProduct.getId() +
                                    "\nName : " + tempProduct.getName() +
                                    "\nQuantity : " + tempProduct.getQuantity())
                            .create().show();
                    mQNumberEditText.setText("");
                    break;

                case 2:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Product Info")
                            .setMessage(tempProductsData)
                            .create().show();
                    mQNameEditText.setText("");
                    break;

                case 3:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Product Info")
                            .setMessage(tempProductsData)
                            .create().show();
                    break;

                case 4:
                    Toast.makeText(MainActivity.this, "Product deleted.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "product-db").build();

        initialization();

        clickEvents();
    }

    private void initialization() {
        mINumberEditText = findViewById(R.id.editText_enroll);
        mINameEditText = findViewById(R.id.editText_name);
        mIquantityEditText = findViewById(R.id.editText_quantity);
        mQNumberEditText = findViewById(R.id.editText_q_id);
        mQNameEditText = findViewById(R.id.editText_q_name);
        mInsertButton = findViewById(R.id.button_insert);
        mSearchByIdButton = findViewById(R.id.button_search_id);
        mDeleteButton = findViewById(R.id.button_delete);
        mSearchByNameButton = findViewById(R.id.button_search_name);
        mRetrieveAllButton = findViewById(R.id.button_get_all);
    }

    private void clickEvents() {
        mInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Product product = new Product();
                        product.setId(Integer.parseInt(mINumberEditText.getText().toString()));
                        product.setName(mINameEditText.getText().toString());
                        product.setQuantity(mIquantityEditText.getText().toString());
                        try {
                            mDatabase.productDao().insertProduct(product);
                            insertMessage = "Product added successfully.";
                        } catch (SQLiteConstraintException e) {
                            insertMessage = "Product data on this enrollment number already exists!!!";
                        }
                        handler.sendEmptyMessage(0);
                    }
                }).start();
            }
        });

        mSearchByIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        tempProduct = mDatabase.productDao()
                                .getProductById(Integer.parseInt(mQNumberEditText.getText().toString()));
                        handler.sendEmptyMessage(1);
                    }
                }).start();
            }
        });

        mSearchByNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        products = mDatabase.productDao().getProductByName(mQNameEditText.getText().toString());
                        for (Product product : products) {
                            tempProductsData = tempProductsData + "\nId no. : " + product.getId() +
                                    "\nName : " + product.getName() +
                                    "\nQuantity : " + product.getQuantity();
                        }
                        handler.sendEmptyMessage(2);
                    }
                }).start();
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mDatabase.productDao()
                                .deleteProduct(mDatabase.productDao()
                                        .getProductById(Integer.parseInt(mQNumberEditText.getText()
                                                .toString())));
                        handler.sendEmptyMessage(4);
                    }
                }).start();
            }
        });

        mRetrieveAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        products = mDatabase.productDao().getAll();
                        for (Product product : products) {
                            tempProductsData = tempProductsData + "\nId no. : " + product.getId() +
                                    "\nName : " + product.getName() +
                                    "\nQuantity : " + product.getQuantity();
                        }
                        handler.sendEmptyMessage(3);
                    }
                }).start();
            }
        });
    }
}
