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
import android.widget.TimePicker;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;
import com.hbb20.CountryCodePicker;


public class Fragment_Third_shipping_Transportation extends Fragment {
    private EditText  txt_phone;
    private Button previous,next;
    private ImageView next_img,previous_img,date_clock;
    private CountryCodePicker phonecode;
    private Home_Activity activity;
    private Preferences preferences;
    private String current_lang;


    // TODO: Rename and change types and number of parameters
    public static Fragment_Third_shipping_Transportation newInstance() {
       return new Fragment_Third_shipping_Transportation();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_third_shipping__transportation, container, false);
        intitview(view);
        return view;
    }

    private void intitview(View view) {
        preferences=Preferences.getInstance();
        activity=(Home_Activity)getActivity();
        current_lang= preferences.getlang(activity);
        previous=view.findViewById(R.id.previous);
        next=view.findViewById(R.id.next_shipping);
        next_img=view.findViewById(R.id.image_next);
        previous_img=view.findViewById(R.id.image_previous);
        date_clock=view.findViewById(R.id.date_clock);
        phonecode = view.findViewById(R.id.phone_num_code_chooser);
        txt_phone = view.findViewById(R.id.phone_num_edittxt);

        if(current_lang.equals("ar")){
            phonecode.setBackground(getResources().getDrawable(R.drawable.text_right_shape));
            txt_phone.setBackground(getResources().getDrawable(R.drawable.text_left_shape));
            previous_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_right_previous));
            next_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_left_arrow_previous));
        }

        phonecode.registerCarrierNumberEditText(txt_phone);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Back();
            }
        });
date_clock.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        TimePickerDialog timePickerDialog=new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int mintues) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                    }
                },00,00,00);
                datePickerDialog.show();
            }
        },00,00,false);
        timePickerDialog.show();
    }
});



next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        activity.DisplayFragmentshipping_Fourth();
    }
});
    }


}
