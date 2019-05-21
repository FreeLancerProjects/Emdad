package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;
import com.hbb20.CountryCodePicker;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Locale;


public class Fragment_seconed_shipping_Transportation extends Fragment {
    private Button next, previous;
    private ImageView next_img, previous_img, date, clock;
    private CountryCodePicker phonecode;
    private EditText txtdate, txtclock, txt_phone;
    private Home_Activity activity;
    private String current_lang, timeclock="";
    private int years, months, days, hour, minute;

    public static Fragment_seconed_shipping_Transportation newInstance() {
        return new Fragment_seconed_shipping_Transportation();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seconed_shipping_transportation, container, false);
        intitview(view);
        return view;
    }

    private void intitview(View view) {
        current_lang = Locale.getDefault().getLanguage();
        activity = (Home_Activity) getActivity();
        next = view.findViewById(R.id.next_shipping);
        previous = view.findViewById(R.id.previous);
        next_img = view.findViewById(R.id.image_next);
        previous_img = view.findViewById(R.id.image_previous);
        phonecode = view.findViewById(R.id.txt_phone_num_code);
        txt_phone = view.findViewById(R.id.txt_phone_num);
        txtdate = view.findViewById(R.id.txt_date);
        txtclock = view.findViewById(R.id.txt_clock);
        date = view.findViewById(R.id.date);
        clock = view.findViewById(R.id.clock);
        if (current_lang.equals("ar")) {
            phonecode.setBackground(getResources().getDrawable(R.drawable.text_right_shape));
            txt_phone.setBackground(getResources().getDrawable(R.drawable.text_left_shape));
            previous_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_right_previous));
            next_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_left_arrow_previous));

        }
        phonecode.registerCarrierNumberEditText(txt_phone);

        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        hour = hourOfDay;
                        minute = minutes;
                        timeclock += hourOfDay < 10 ? "0" + hourOfDay : hourOfDay;
                        timeclock += minutes < 10 ? ": 0" + minutes : ":" + minutes;
                        txtclock.setText(timeclock);
                    }
                }, 00, 00, false);
                timePickerDialog.show();

            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        days = dayOfMonth;
                        months = month;
                        years = year;
                        if (current_lang.equals("ar")) {
                            txtdate.setText(year + "-" + month + "-" + dayOfMonth);
                        } else {
                            txtdate.setText(dayOfMonth + "-" + month + "-" + year);
                        }
                    }
                }, 0, 0, 0);
                datePickerDialog.show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentshipping_Third();

            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Back();
            }
        });
    }
}
