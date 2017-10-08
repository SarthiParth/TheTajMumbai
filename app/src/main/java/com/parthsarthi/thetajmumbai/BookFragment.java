package com.parthsarthi.thetajmumbai;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


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
                validateFields();
            }
        });

        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "geosans.ttf");
        ((TextView) v.findViewById(R.id.bookHead)).setTypeface(face);

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
                EditText inDateText = v.findViewById(R.id.checkInDate);
                if (TextUtils.isEmpty(inDateText.getText().toString())) {
                    Toast.makeText(getContext(), "Select Check-in Date first", Toast.LENGTH_SHORT).show();
                } else {
                    DateDialog dialog = new DateDialog(view);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "Select Check-Out Date");
                }
            }
        });

    }

    private void validateFields() {
        int flag = 0;
        EditText nameText = v.findViewById(R.id.name);
        EditText addressText = v.findViewById(R.id.postalAddress);
        EditText emailText = v.findViewById(R.id.email);
        EditText phoneText = v.findViewById(R.id.mobile);
        EditText inDateText = v.findViewById(R.id.checkInDate);
        EditText outDateText = v.findViewById(R.id.checkOutDate);
        EditText numAdultText = v.findViewById(R.id.noOfAdults);
        EditText numChildText = v.findViewById(R.id.noOfChild);

        if (TextUtils.isEmpty(nameText.getText().toString())) {
            nameText.setError("Required");
            flag = 1;
        }
        if (TextUtils.isEmpty(addressText.getText().toString())) {
            addressText.setError("Required");
            flag = 1;
        }
        if (!isValidEmail(emailText.getText().toString())) {
            emailText.setError("Invalid Email");
            flag = 1;
        }
        if (TextUtils.isEmpty(emailText.getText().toString())) {
            emailText.setError("Required");
            flag = 1;
        }
        if (!isValidMobile(phoneText.getText().toString())) {
            phoneText.setError("Invalid Phone Number");
            flag = 1;
        }
        if (TextUtils.isEmpty(phoneText.getText().toString())) {
            phoneText.setError("Required");
            flag = 1;
        }
        if (TextUtils.isEmpty(inDateText.getText().toString())) {
            inDateText.setError("Required");
            flag = 1;
        }
        if (TextUtils.isEmpty(outDateText.getText().toString())) {
            outDateText.setError("Required");
            flag = 1;
        }
        if (TextUtils.isEmpty(numAdultText.getText().toString())) {
            numAdultText.setError("Required");
            flag = 1;
        }
        if (TextUtils.isEmpty(numChildText.getText().toString())) {
            numChildText.setError("Required");
            flag = 1;
        }
        if (flag == 0)
            Toast.makeText(getContext(), "Thanks for booking your stay with us!\nOur representative will get in touch with you shortly.", Toast.LENGTH_LONG).show();
    }

    private boolean isValidEmail(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidMobile(CharSequence phone) {
        return !(phone.length() < 6 || phone.length() > 13) && android.util.Patterns.PHONE.matcher(phone).matches();
    }

}
