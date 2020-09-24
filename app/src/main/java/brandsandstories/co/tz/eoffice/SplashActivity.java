package brandsandstories.co.tz.eoffice;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundColor(Color.parseColor("silver"))
                .withLogo(R.drawable.logo);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);

    }
}