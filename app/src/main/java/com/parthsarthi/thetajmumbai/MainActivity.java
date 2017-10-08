package com.parthsarthi.thetajmumbai;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    FragmentManager manager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.contentLayout,
                            homeFragment
                    ).commit();
                    return true;
                case R.id.navigation_about:
                    AboutFragment aboutFragment = new AboutFragment();
                    manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.contentLayout,
                            aboutFragment
                    ).commit();
                    return true;
                case R.id.navigation_book:
                    BookFragment bookFragment = new BookFragment();
                    manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.contentLayout,
                            bookFragment
                    ).commit();
                    return true;
                case R.id.navigation_contact:
                    ContactFragment contactFragment = new ContactFragment();
                    manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.contentLayout,
                            contactFragment
                    ).commit();
                    return true;
                case R.id.navigation_rooms:
                    RoomFragment roomFragment = new RoomFragment();
                    manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(
                            R.id.contentLayout,
                            roomFragment
                    ).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeFragment homeFragment = new HomeFragment();
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(
                R.id.contentLayout,
                homeFragment
        ).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}