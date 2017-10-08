package com.parthsarthi.thetajmumbai;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class HomeFragment extends Fragment {

    CarouselView carouselView;
    TabLayout tabLayout;
    ViewPager viewPager;
    int[] homeSlide = {R.drawable.img5, R.drawable.img3, R.drawable.img4, R.drawable.img2, R.drawable.img6};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(homeSlide[position]);
        }
    };
    private View v;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.home, container, false);

        carouselView = v.findViewById(R.id.carouselView);
        carouselView.setPageCount(homeSlide.length);
        carouselView.setImageListener(imageListener);

        viewPager = v.findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAdapter(getFragmentManager(), getContext()));

        tabLayout = v.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "ostrichsans.ttf");
        ((TextView) v.findViewById(R.id.expTaj)).setTypeface(face);

        return v;
    }

    private class CustomAdapter extends FragmentStatePagerAdapter {

        private String fragments[] = {"Hotel Facilities", "Wellness Amenities", "Other Conveniences"};

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HotelFacilitiesFragment();
                case 1:
                    return new WellnessAmenitiesFragment();
                case 2:
                    return new OtherConveniencesFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }

    }

}
