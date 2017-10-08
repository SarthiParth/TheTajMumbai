package com.parthsarthi.thetajmumbai;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;


@SuppressLint("ValidFragment")
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText dateText;
    int cyear, cmonth, cday;

    public DateDialog(View view) {
        dateText = (EditText) view;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DatePickerDialog date = new DatePickerDialog(getActivity(), this, cyear, cmonth, cday);
        final Calendar c = Calendar.getInstance();
        Date currentDate = c.getTime();
        cyear = c.get(Calendar.YEAR);
        cmonth = c.get(Calendar.MONTH);
        cday = c.get(Calendar.DAY_OF_MONTH);
        date.getDatePicker().setMinDate(currentDate.getTime());
        return date;

    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        String date = day + "/" + (month + 1) + "/" + year;
        dateText.setText(date);
    }

}
