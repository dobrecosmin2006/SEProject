
package snake.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {

    /*
            This is my main class for the running project-game
     */
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Snake-Catch the worm";
		cfg.useGL20 = true;
		cfg.width = 320;
		cfg.height = 480;
		
		new LwjglApplication(new SerpGame(), cfg);
	}
}
