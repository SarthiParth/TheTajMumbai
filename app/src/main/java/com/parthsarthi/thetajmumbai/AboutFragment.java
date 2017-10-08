package com.parthsarthi.thetajmumbai;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class AboutFragment extends Fragment {

    ExpandableTextView expandableTextView;
    private View v;
    private Typeface face;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.about, container, false);

        expandableTextView = v.findViewById(R.id.expand_history_view);
        expandableTextView.setText(getContext().getString(R.string.about_history));

        expandableTextView = v.findViewById(R.id.expand_location_view);
        expandableTextView.setText(getContext().getString(R.string.about_location));

        expandableTextView = v.findViewById(R.id.expand_cuisines_view);
        expandableTextView.setText(getContext().getString(R.string.about_cuisines));

        expandableTextView = v.findViewById(R.id.expand_facilities_view);
        expandableTextView.setText(getContext().getString(R.string.about_facilities));

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
