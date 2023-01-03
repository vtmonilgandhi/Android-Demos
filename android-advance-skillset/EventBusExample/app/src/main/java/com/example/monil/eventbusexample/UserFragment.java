package com.example.monil.eventbusexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {
    TextView messageView;
    EditText etMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Register the event to subscribe.
        GlobalBus.getBus().register(this);
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        messageView = (TextView) rootView.findViewById(R.id.message);
        etMessage = (EditText) rootView.findViewById(R.id.editText);
        Button sendBtn = rootView.findViewById(R.id.submit);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessageToFragment(view);
            }
        });
        return rootView;
    }

    public void sendMessageToFragment(View view) {

        Events.FragmentActivityMessage fragmentActivityMessage =
                new Events.FragmentActivityMessage(String.valueOf(etMessage.getText()));

        GlobalBus.getBus().post(fragmentActivityMessage);
    }

    @Subscribe
    public void getMessage(Events.ActivityFragmentMessage activityFragmentMessage) {
        //Write code to perform action after event is received.

        messageView.setText(getString(R.string.message_received) + " " + activityFragmentMessage.getMessage());

        Toast.makeText(getActivity(),
                getString(R.string.message_main_activity) + " " + activityFragmentMessage.getMessage(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Unregister the registered event.
        GlobalBus.getBus().unregister(this);
    }
}