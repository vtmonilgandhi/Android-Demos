package com.example.monil.eventbusexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
    TextView messageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         messageView = (TextView) findViewById(R.id.message);
        Button sendBtn=findViewById(R.id.sendMessageToFragment);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessageToFragment(view);
            }
        });
        addFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Register this fragment to listen to event.
        GlobalBus.getBus().register(this);
    }

    private void addFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer, new UserFragment())
                .commit();
    }

    public void sendMessageToFragment(View view) {
        EditText etMessage = (EditText) findViewById(R.id.activityData);
        Events.ActivityFragmentMessage activityFragmentMessageEvent =
                new Events.ActivityFragmentMessage(String.valueOf(etMessage.getText()));

        GlobalBus.getBus().post(activityFragmentMessageEvent);
    }

    @Subscribe
    public void getMessage(Events.FragmentActivityMessage fragmentActivityMessage) {

        messageView.setText(getString(R.string.message_received) + " " + fragmentActivityMessage.getMessage());

        Toast.makeText(getApplicationContext(),
                getString(R.string.message_main_activity) + " " + fragmentActivityMessage.getMessage(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        GlobalBus.getBus().unregister(this);
    }
}