package com.creativeshare.emdad.Activites_Fragments.Fragments;


import android.app.ProgressDialog;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.creativeshare.emdad.Activites_Fragments.Activites.Login_Activity;
import com.creativeshare.emdad.Model.UserModel;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.Share.Common;
import com.creativeshare.emdad.remote.Api;
import com.hbb20.CountryCodePicker;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Signup extends Fragment {
    private CountryCodePicker ccp;
    private EditText userfullname, username, userpass, useremail, edtPhoneNumber;
    private String fullname, name, pass, email, phone, phonecode;
    private Button signup;
    private ProgressBar progBar;
    private Login_Activity login_activity;

    // TODO: Rename and change types and number of parameters
    public static Fragment_Signup newInstance() {
        return new Fragment_Signup();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        intitview(view);
        return view;
    }

    private void intitview(final View view) {
        login_activity = (Login_Activity) getActivity();
        ccp = view.findViewById(R.id.ccp);
        edtPhoneNumber = view.findViewById(R.id.phone_signup);
        signup = view.findViewById(R.id.bt_signup);
        userfullname = view.findViewById(R.id.name_signup);
        username = view.findViewById(R.id.user_signup);
        userpass = view.findViewById(R.id.password_signup);
        useremail = view.findViewById(R.id.email_signup);
        progBar = view.findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(login_activity, R.color.yellow1), PorterDuff.Mode.SRC_IN);
        progBar.setVisibility(View.GONE);
        ccp.registerCarrierNumberEditText(edtPhoneNumber);
        ccp.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {
                if(ccp.isValidFullNumber()){
                    edtPhoneNumber.setError("");
                }
            }
        });
signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progBar.setVisibility(View.VISIBLE);
                Signup(view);
            }
        });

    }

    private void Signup(View view) {
        fullname = userfullname.getText().toString();
        name = username.getText().toString();
        pass = userpass.getText().toString();
        email = useremail.getText().toString();
        //phonecode = ccp.getSelectedCountryCode();
        phone = edtPhoneNumber.getText().toString();

        if (!ccp.isValidFullNumber() || fullname.isEmpty() || name.isEmpty() || pass.isEmpty() || email.isEmpty() || !Common.isValidMail(email) || phone.isEmpty()) {
            progBar.setVisibility(View.GONE);
            if (!ccp.isValidFullNumber() || phone.isEmpty()) {
                edtPhoneNumber.setError("");
            }
            if (fullname.isEmpty()) {
                userfullname.setError("");
            }
            if (name.isEmpty()) {
                username.setError("");
            }
            if (pass.isEmpty()) {
                userpass.setError("");
            }
            if (email.isEmpty() || !Common.isValidMail(email)) {
                useremail.setError("");
            }
        } else {
            Common.CloseKeyBoard(login_activity, view);
            Api.getService().register(fullname, name, email, pass, phonecode, phone, 1).enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    //      dialog.dismiss();
                    progBar.setVisibility(View.GONE);
                    if (response.isSuccessful()) {
                        login_activity.openHome(response.body());
                    } else {
                        Common.CreateErrorAlertDialog(login_activity, response.message());
                    }
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    Log.e("Error", t.getMessage());
                    Common.CreateErrorAlertDialog(login_activity, "Faild");
                    //    dialog.dismiss();
                    progBar.setVisibility(View.GONE);

                }
            });
        }
    }


}
