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


@SuppressLint("ValidFragment")
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private final long dateToSet;
    EditText dateText;
    int cyear, cmonth, cday;

    public DateDialog(View view, long dateToSet) {
        dateText = (EditText) view;
        this.dateToSet = dateToSet;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DatePickerDialog date = new DatePickerDialog(getActivity(), this, cyear, cmonth, cday);
        date.getDatePicker().setMinDate(dateToSet);
        return date;

    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        String date = day + "/" + (month + 1) + "/" + year;
        dateText.setText(date);
    }

}
