package byteuawesome.bungkus.ActivitySplash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import byteuawesome.bungkus.ActivityLogin.Login;
import byteuawesome.bungkus.R;

/**
 * Created by Laptop on 3/11/2018.
 */

public class Splash extends AppCompatActivity {

    ImageView ivSplash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivSplash = (ImageView) findViewById(R.id.image_view_splash);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        ivSplash.startAnimation(anim);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // TODO check is logged in
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                }
            }
        };
        timer.start();
    }
}