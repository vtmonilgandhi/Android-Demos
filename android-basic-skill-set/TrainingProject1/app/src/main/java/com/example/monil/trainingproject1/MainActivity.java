package com.example.monil.trainingproject1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
<<<<<<< HEAD
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    TabLayout tabLayout;
    private Tab1Fragment tab1Fragment;
    private Tab2Fragment tab2Fragment;
    private Tab3Fragment tab3Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initComponent();
        prepareViews();
        setListeners();

        tabLayout.addTab(tabLayout.newTab().setText("Group1"), true);
        tabLayout.addTab(tabLayout.newTab().setText("Group2"));
        tabLayout.addTab(tabLayout.newTab().setText("Group3"));

        tabLayout.addOnTabSelectedListener(this);
        replaceFragment(new Tab1Fragment());


    }

    @Override
    protected void initComponent() {


        tabLayout = (TabLayout) findViewById(R.id.tabs);

    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        if (tab.getPosition() == 0) {
            replaceFragment(new Tab1Fragment());
        } else if (tab.getPosition() == 1) {
            replaceFragment(new Tab2Fragment());
        } else {
            replaceFragment(new Tab3Fragment());
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.commit();
    }
}
=======
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

        public class MainActivity extends AppCompatActivity {


            private SectionsPagerAdapter mSectionsPagerAdapter;
            private ViewPager mViewPager;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
                mViewPager = (ViewPager) findViewById(R.id.container);
                mViewPager.setAdapter(mSectionsPagerAdapter);

                TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                tabLayout.setupWithViewPager(mViewPager);

            }


            public class SectionsPagerAdapter extends FragmentPagerAdapter {

                public SectionsPagerAdapter(FragmentManager fm) {
                    super(fm);
                }

                @Override
                public Fragment getItem(int position) {

                    switch (position) {
                        case 0:
                            return new Tab1Fragment();
                        default:
                            return new Tab2Fragment();

                    }
                }

                @Override
                public int getCount() {
                    return 2;
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    switch (position) {
                        case 0:
                            return "Login";
                        case 1:
                            return "Registration";

                    }
                    return null;
                }
            }
        }
>>>>>>> 306da3b378576ca2dec29e87f3df9b850a2286d1
