package com.example.monil.multipaneexample.Fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.monil.multipaneexample.OnVersionNameSelectionChangeListener;
import com.example.monil.multipaneexample.R;

public class VersionsFragment extends ListFragment {


    // Mandatory empty constructor for the fragment manager to instantiate the fragment

    public VersionsFragment() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] versionName = getResources().getStringArray(R.array.version_names);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, versionName);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        OnVersionNameSelectionChangeListener listener = (OnVersionNameSelectionChangeListener) getActivity();
        listener.OnSelectionChanged(position);
    }
}