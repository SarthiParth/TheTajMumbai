package com.parthsarthi.thetajmumbai;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class ContactFragment extends Fragment implements OnMapReadyCallback {

    private View v;
    private GoogleMap mMap;
    private Typeface face;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (v == null) {
            v = inflater.inflate(R.layout.contact, container, false);
        }
        if (mMap == null) {
            SupportMapFragment mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            mapFrag.getMapAsync(this);
        }

        v.findViewById(R.id.webText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://taj.tajhotels.com/en-in/taj-mahal-palace-mumbai/")
                ));
            }
        });

        v.findViewById(R.id.fbBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("fb://page/15960887978")
                    ));
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/profile.php?id=15960887978")
                    ));
                }
            }
        });

        v.findViewById(R.id.twitterBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.twitter.com/tajhotels")
                ));
            }
        });

        v.findViewById(R.id.gplusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://plus.google.com/111274684328188449076")
                ));
            }
        });

        v.findViewById(R.id.instaBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/tajmahalmumbai")
                ));
            }
        });

        v.findViewById(R.id.pinBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.pinterest.com/tajhotels")
                ));
            }
        });

        v.findViewById(R.id.ytBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/user/TajMovies")
                ));
            }
        });

        face = Typeface.createFromAsset(getActivity().getAssets(), "geosans.ttf");
        ((TextView) v.findViewById(R.id.contactHead)).setTypeface(face);
        face = Typeface.createFromAsset(getActivity().getAssets(), "champagne_limousines.ttf");
        ((TextView) v.findViewById(R.id.socialText)).setTypeface(face);

        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng taj = new LatLng(18.921727, 72.833020);
        mMap.addMarker(new MarkerOptions().position(taj).title("The Taj Mahal Palace"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(taj, 17));
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

}
