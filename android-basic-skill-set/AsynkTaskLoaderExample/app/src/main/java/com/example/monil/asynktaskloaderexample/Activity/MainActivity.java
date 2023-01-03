package com.example.monil.asynktaskloaderexample.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.example.monil.asynktaskloaderexample.ListFragmentExp;
import com.example.monil.asynktaskloaderexample.R;

public class MainActivity extends FragmentActivity{
	FragmentTransaction mTFragmentTransaction;
	FragmentManager mManFragmentManager;
	ListFragmentExp mListFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListFragment = new ListFragmentExp();
		FrameLayout cursor = (FrameLayout) findViewById(R.id.listFragment);
		mManFragmentManager = getSupportFragmentManager();

		if (mManFragmentManager.findFragmentByTag("Tag") == null) {
			mTFragmentTransaction = mManFragmentManager.beginTransaction();
			mTFragmentTransaction.add(cursor.getId(), mListFragment, "Tag");
			mTFragmentTransaction.commit();
		}
	}
}
