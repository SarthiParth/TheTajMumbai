package com.parthsarthi.thetajmumbai;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ms.square.android.expandabletextview.ExpandableTextView;


public class HotelFacilitiesFragment extends Fragment {

    ExpandableTextView expandableTextView;
    private View v;

    public HotelFacilitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.hotel_facilities, container, false);

        expandableTextView = v.findViewById(R.id.expand_hotel_facilities_view);
        expandableTextView.setText(getContext().getString(R.string.hotel_facilities));

        return v;
    }

}
