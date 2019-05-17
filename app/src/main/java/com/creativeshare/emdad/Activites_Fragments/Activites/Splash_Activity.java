package com.creativeshare.emdad.Activites_Fragments.Activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.creativeshare.emdad.Language.Language;
import com.creativeshare.emdad.R;


public class Splash_Activity extends AppCompatActivity {
   private FrameLayout im;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Language.updateResources(newBase, Language.getLanguage(newBase)));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        intitview();
    }

    private void intitview() {
        im=(FrameLayout)findViewById(R.id.fl);
        Animation animation;

        animation= AnimationUtils.loadAnimation(getBaseContext(),R.anim.lanuch);
         /*  IndicatorSeekBar seekBar = IndicatorSeekBar
                .with(getApplicationContext())
                .max(110)
                .min(10)
                .progress(53)
                .tickCount(7)
                .showTickMarksType(TickMarkType.OVAL)

                .tickMarksSize(13)//dp
                .showTickTexts(true)
                .tickTextsSize(13)//sp
                .tickTextsTypeFace(Typeface.MONOSPACE)
                .showIndicatorType(IndicatorType.ROUNDED_RECTANGLE)
                .indicatorColor(Color.parseColor("#f0bc08"))
                .indicatorTextColor(Color.parseColor("#ffffff"))
                .indicatorTextSize(13)//sp
                .thumbColor(Color.parseColor("#f0bc08"))
                .thumbSize(14)
                .trackProgressColor(Color.parseColor("#f0bc08"))
                .trackProgressSize(4)
                .trackBackgroundColor(Color.parseColor("#f0bc08"))
                .trackBackgroundSize(2)
                .onlyThumbDraggable(false)
                .build();*/
        im.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(Splash_Activity.this,Login_Activity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
