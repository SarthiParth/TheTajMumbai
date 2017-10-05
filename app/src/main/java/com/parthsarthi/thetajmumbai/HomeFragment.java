package com.parthsarthi.thetajmumbai;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class HomeFragment extends Fragment {

    private View v;
    CarouselView carouselView;
    int[] homeSlide = {R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};

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

        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "ostrichsans.ttf");
        ((TextView) v.findViewById(R.id.expTaj)).setTypeface(face);

        return v;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(homeSlide[position]);
        }
    };

}
