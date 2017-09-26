package com.parthsarthi.thetajmumbai;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.contentLayout,
                            homeFragment,
                            homeFragment.getTag()
                    ).commit();
                    return true;
                case R.id.navigation_about:
                    AboutFragment aboutFragment = new AboutFragment();
                    manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.contentLayout,
                            aboutFragment,
                            aboutFragment.getTag()
                    ).commit();
                    return true;
                case R.id.navigation_book:
                    return true;
                case R.id.navigation_contact:
                    ContactFragment contactFragment = new ContactFragment();
                    manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.contentLayout,
                            contactFragment,
                            contactFragment.getTag()
                    ).commit();
                    return true;
                case R.id.navigation_gallery:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}