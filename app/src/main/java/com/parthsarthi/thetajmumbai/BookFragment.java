package com.parthsarthi.thetajmumbai;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class BookFragment extends Fragment {

    private View v;

    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.book, container, false);
        Spinner spinner = v.findViewById(R.id.rooms);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.rooms_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button button = v.findViewById(R.id.bookBtn);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getContext(), "Thanks for booking your stay with us!\nOur representative will get in touch with you shortly.", Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }


    public void onStart() {
        super.onStart();

        EditText inDate = v.findViewById(R.id.checkInDate);
        inDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    DateDialog dialog = new DateDialog(view);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "Select Check-In Date");
            }
        });

        EditText outDate = v.findViewById(R.id.checkOutDate);
        outDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DateDialog dialog = new DateDialog(view);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dialog.show(ft, "Select Check-Out Date");
            }
        });

    }

}
