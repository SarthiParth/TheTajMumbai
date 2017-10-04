package com.parthsarthi.thetajmumbai;


import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;


@SuppressLint("ValidFragment")
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText dateText;
    int cyear, cmonth, cday;

    public DateDialog(View view) {
        dateText = (EditText) view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        cyear = c.get(Calendar.YEAR);
        cmonth = c.get(Calendar.MONTH);
        cday = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, cyear, cmonth, cday);

    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        if ((year < cyear) || (year == cyear && month < cmonth) || (year == cyear && month == cmonth && day < cday)) {
            Toast.makeText(getContext(), "Cannot select backdate!", Toast.LENGTH_LONG).show();
        } else {
            String date = day + "/" + (month + 1) + "/" + year;
            dateText.setText(date);
        }
    }

}
