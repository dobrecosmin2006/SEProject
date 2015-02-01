package snake.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Settings {
	
	// i need to load the preferences from GDX library 
	
	public static Preferences snakeSettings = Gdx.app
			.getPreferences("snakeSettings");
	public static Preferences snakeHighscores = Gdx.app
			.getPreferences("snakeHighscores");

	// add score into the main DataBase
	
	
}