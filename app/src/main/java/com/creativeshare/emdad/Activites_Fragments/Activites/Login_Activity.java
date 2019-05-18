package com.creativeshare.emdad.Activites_Fragments.Activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Login;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Signup;
import com.creativeshare.emdad.Language.Language;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;

import java.util.Locale;


public class Login_Activity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private Fragment_Login fragmentLogin;
    private Fragment_Signup fragmentsignup;
    private ImageView sign_login;
    private String current_lang;
    private Preferences preferences;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Language.updateResources(newBase, Language.getLanguage(newBase)));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
         intitview();
        if (savedInstanceState == null) {
            fragmentManager = this.getSupportFragmentManager();

            DisplayLoginFragment();

        }
    }

    private void intitview() {
        preferences=Preferences.getInstance();
        current_lang= preferences.getlang(this);
        sign_login=findViewById(R.id.login_sign_arrow);
        if(current_lang.equals("en")){
            sign_login.setRotation(180);}
            sign_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(fragmentLogin!=null&&fragmentLogin.isVisible()){
                        DisplaysignupFragment();
                    }
                    else{
                        DisplayLoginFragment();
                    }
                }
            });


    }

    private void DisplayLoginFragment() {
        if(fragmentsignup!=null&&fragmentsignup.isAdded()){
            fragmentManager.beginTransaction().hide(fragmentsignup).commit();
        }
        if (fragmentLogin == null) {
            fragmentLogin = Fragment_Login.newInstance();
        }
        if (fragmentLogin.isAdded()) {
            fragmentManager.beginTransaction().show(fragmentLogin).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_login_register, fragmentLogin, "fragmentLogin").addToBackStack("fragmentLogin").commit();
        }
    }
    private void DisplaysignupFragment() {
        if(fragmentLogin!=null&&fragmentLogin.isAdded()){
            fragmentManager.beginTransaction().hide(fragmentLogin).commit();
        }
        if (fragmentsignup == null) {
            fragmentsignup = Fragment_Signup.newInstance();
        }
        if (fragmentsignup.isAdded()) {
            fragmentManager.beginTransaction().show(fragmentsignup).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_login_register, fragmentsignup, "fragmentsignup").addToBackStack("fragmentsignup").commit();
        }
    }

    public void openHome() {
        Intent intent=new Intent(Login_Activity.this,Home_Activity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void skip() {
        Intent intent=new Intent(Login_Activity.this,Home_Activity.class);
        startActivity(intent);
    }
}
