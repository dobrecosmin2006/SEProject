package es.dokansoft.gdx.serp;

import snake.game.SerpGame;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = true;
        cfg.useWakelock = true;
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        
        initialize(new SerpGame(), cfg);
    }
}