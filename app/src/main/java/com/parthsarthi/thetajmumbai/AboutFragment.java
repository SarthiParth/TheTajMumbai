package com.parthsarthi.thetajmumbai;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AboutFragment extends Fragment {

    private View v;
    private Typeface face;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.about, container, false);

        face = Typeface.createFromAsset(getActivity().getAssets(), "geosans.ttf");
        ((TextView) v.findViewById(R.id.aboutHead)).setTypeface(face);
        face = Typeface.createFromAsset(getActivity().getAssets(), "champagne_limousines.ttf");
        ((TextView) v.findViewById(R.id.txtHistory)).setTypeface(face);
        face = Typeface.createFromAsset(getActivity().getAssets(), "champagne_limousines.ttf");
        ((TextView) v.findViewById(R.id.txtCuisines)).setTypeface(face);
        face = Typeface.createFromAsset(getActivity().getAssets(), "champagne_limousines.ttf");
        ((TextView) v.findViewById(R.id.txtLocation)).setTypeface(face);
        face = Typeface.createFromAsset(getActivity().getAssets(), "champagne_limousines.ttf");
        ((TextView) v.findViewById(R.id.txtFacilities)).setTypeface(face);

        return v;
    }

}
