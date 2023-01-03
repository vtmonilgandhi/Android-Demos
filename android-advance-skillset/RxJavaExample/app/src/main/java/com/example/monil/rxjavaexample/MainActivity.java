package com.example.monil.rxjavaexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.monil.rxjavaexample.databinding.ActivityMainBinding;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding rxBinding;
    Observer<String> myObserver;
    int mCounter = 1;
    Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Activity 4");
        createObserver();

        rxBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        rxBinding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rxBinding.startButton.setEnabled(false);
                rxBinding.stopButton.setEnabled(true);

                subscription = Observable.from(rxBinding.editText.getText().toString().split("\n"))
                        .subscribeOn(Schedulers.io())
                        .map(new Func1<String, String>() {
                            @Override
                            public String call(String morphedString) {
                                try {
                                    Thread.sleep(2000);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if (rxBinding.errorToggle.isChecked())
                                    mCounter = 2 / 0;
                                return mCounter++ + ". " + morphedString;
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(myObserver);
            }
        });

        rxBinding.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!subscription.isUnsubscribed())
                    subscription.unsubscribe();
                rxBinding.startButton.setEnabled(true);
                rxBinding.stopButton.setEnabled(false);
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        if (!subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    private void createObserver() {
        myObserver = new Observer<String>() {

            @Override
            public void onCompleted() {
                rxBinding.startButton.setEnabled(true);
                rxBinding.stopButton.setEnabled(false);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this,
                        "A \"" + e.getMessage() + "\" Error has been caught",
                        Toast.LENGTH_LONG).show();
                rxBinding.startButton.setEnabled(true);
                rxBinding.stopButton.setEnabled(false);
            }

            @Override
            public void onNext(String string) {
                rxBinding.textView.setText(rxBinding.textView.getText() + "\n" + string);
            }
        };

    }
}