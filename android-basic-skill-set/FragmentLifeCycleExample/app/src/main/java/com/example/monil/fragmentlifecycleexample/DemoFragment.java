package com.example.monil.fragmentlifecycleexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DemoFragment extends Fragment {
    private void Log(String s) {
// display a message in Log File
        Log.d("LifeCycle:", s);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log("onActivityCreated Called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_demo, container, false);
        Log("onCreateView Called");

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log("onViewCreated Called");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log("onAttach Called");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log("onCreate Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log("onDestroy Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log("onDestroyView Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log("onDetach Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log("onPause Called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log("onResume Called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log("onStart Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log("onStop Called");
    }

}