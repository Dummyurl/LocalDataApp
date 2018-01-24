package app.zingo.com.localdataapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import app.zingo.com.localdataapp.Activity.LoginActivity;




public class SplashActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private ImageView app_logo;
    private TextView text,subtext,hotelText;
    //TrackGPS trackGPS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        app_logo = (ImageView)findViewById(R.id.app_log);
        text = (TextView) findViewById(R.id.hotel_title_text);
        subtext = (TextView) findViewById(R.id.hotel_title_sub_text);
        hotelText = (TextView) findViewById(R.id.splash_hotel_title);
        Animation logo_anim = AnimationUtils.loadAnimation(this,R.anim.transition);
        app_logo.startAnimation(logo_anim);
        text.startAnimation(logo_anim);
        subtext.startAnimation(logo_anim);
        hotelText.startAnimation(logo_anim);



        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
                /*int userId = PreferenceHandler.getInstance(SplashActivity.this).getUserId();
                //System.out.println("User id = "+userId);
                if (userId!=0){
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }*/
//                *//*Intent i = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(i);
//                finish();*//*


            }
        }, 3000);

    }
}
