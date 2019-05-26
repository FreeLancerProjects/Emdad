package com.creativeshare.emdad.Activites_Fragments.Activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.creativeshare.emdad.Language.Language;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.Tags.Tags;
import com.creativeshare.emdad.preferences.Preferences;


public class Splash_Activity extends AppCompatActivity {
   private FrameLayout im;
   private Preferences preferences;
   private String session;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Language.updateResources(newBase, Language.getLanguage(newBase)));
        MultiDex.install(this);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        intitview();
    }

    private void intitview() {
        preferences=Preferences.getInstance();
        session=preferences.getSession(this);
        im=findViewById(R.id.fl);
        Animation animation;

        animation= AnimationUtils.loadAnimation(getBaseContext(),R.anim.lanuch);

        im.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(session.equals(Tags.session_login)){
                    Intent intent = new Intent(Splash_Activity.this, Home_Activity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(Splash_Activity.this, Login_Activity.class);
                    startActivity(intent);
                }
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
