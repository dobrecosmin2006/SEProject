package snake.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import snake.model.Settings;

public class AddScore {
	
	public static Preferences snakeSettings = Gdx.app
			.getPreferences("snakeSettings");
	public static Preferences snakeHighscores = Gdx.app
			.getPreferences("snakeHighscores");

	
	public static void addScore(int score) {
		int k;
		for (int i = 0; i < 5; i++) {
			if (snakeHighscores.getInteger("" + i) < score) {
				for (int j = 4; j > i; j--) {
					k = j - 1;
					snakeHighscores.putInteger("" + j,
							snakeHighscores.getInteger("" + k));
				}
				snakeHighscores.putInteger("" + i, score);
				break;
			}
		}
		snakeHighscores.flush();
		Gdx.app.log("settings", "addScore(), score: " + score);

		// put all settings into the Highscore implemented 
		for (int i = 0; i < 5; i++) {
			Gdx.app.log("settings", "serpHighscore[" + i + "]: "+ snakeHighscores.getInteger("" + i));
		}
	}
	
}
