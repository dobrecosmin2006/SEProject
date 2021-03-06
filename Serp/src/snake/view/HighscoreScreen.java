package snake.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import snake.model.Settings;

public class HighscoreScreen extends SerpScreen {
	float vwidth = 320f; // v from virtual
	float vheight = 480f;
	private float ppuX; // pixels per unit on the X axis
	private float ppuY; // pixels per unit on the Y axis
	float width, height = 0;

	SpriteBatch spriteBatch;

	String lines[] = new String[5];

	Preferences settings;
	Preferences highscores;

	Texture background;
	Texture mainMenu;
	Texture numbers;
	Texture buttons;

	//Sound click;

	public HighscoreScreen(Game game) {
		super(game);
		Gdx.app.error("HighscoreScreen", "Constructor: super(game) job done!");

		spriteBatch = new SpriteBatch();

		settings = Settings.snakeSettings;
		highscores = Settings.snakeHighscores;

		background = Assets.background;
		mainMenu = Assets.mainMenu;
		numbers = Assets.numbers;
		buttons = Assets.buttons;
		
		setLines();

	}

	public HighscoreScreen(Game game, AssetManager assets) {
		super(game, assets);
		Gdx.app.error("HighscoreScreen",
				"Constructor: super(game,assets) job done!");

		spriteBatch = new SpriteBatch();

		settings = Settings.snakeSettings;
		highscores = Settings.snakeHighscores;

		background = assets.get("background.png", Texture.class);
		mainMenu = assets.get("mainmenu.png", Texture.class);
		numbers = assets.get("numbers.png", Texture.class);
		buttons = assets.get("buttons.png", Texture.class);

	

		setLines();
		
	}

	@Override
	public void render(float delta) {
		inputController();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		spriteBatch.begin();
		spriteBatch.draw(background, 0, 0, width, height); 
		
		spriteBatch.draw(mainMenu, 64 * ppuX, height - 62 * ppuY, 196 * ppuX,
				42 * ppuY, 0, 42, 196, 42, false, false);
		spriteBatch.draw(buttons, 256 * ppuX, 0, 64 * ppuX, 64 * ppuY, 0, 64,
				64, 64, false, false);

		int y = 120;
		for (int i = 4; i >= 0; i--) {
			drawText(lines[i], 40, y);
			y += 60;
		}

		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
		// this.ratio = this.width/this.height;
		ppuX = (float) width / vwidth;
		Gdx.app.log("Stress", "resize().ppuX: " + ppuX);
		ppuY = (float) height / vheight;
		Gdx.app.log("Stress", "resize().ppuY: " + ppuY);

		spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
	}

	@Override
	public void drawText(String line, int x, int y) {
		/*
		 * 
		 */
		Gdx.app.log("HighscoreScreen",
				"drawText(), line.isEmpty(): " + line.isEmpty());
		int len = line.length();

		for (int i = 0; i < len; i++) {
			char character = line.charAt(i);

			if (character == ' ') {
				x += 20;
				continue;
			}

			int srcX = 0;
			int srcWidth = 0;
			if (character == '.') {
				srcX = 200;
				srcWidth = 10;
			} else {
				srcX = (character - '0') * 20;
				srcWidth = 20;
			}

			/*
		
			 */
			spriteBatch.draw(numbers, x * ppuX, y * ppuY, srcWidth * ppuX,
					32 * ppuY, srcX, 0, srcWidth, 32, false, false);
			x += srcWidth;
		}
	}

	public void inputController() {
		if (Gdx.input.justTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			if (inBounds(touchPos, 256 * ppuX, 416 * ppuY, 64 * ppuX, 64 * ppuY)) {
				if (settings.getBoolean("soundOn"))
					//click.play(1);
				if (this.assets == null)
					game.setScreen(new MainMenuScreen(game));
				if (this.assets != null)
					game.setScreen(new MainMenuScreen(game, assets));
				return;
			}
		}
	}

	private void setLines() {

		for (int i = 0; i < 5; i++) {
			lines[i] = "" + highscores.getInteger("" + i);
		}
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
	}

	@Override
	public void show() {
		// Auto-generated method stub

	}

	@Override
	public void hide() {
		// Auto-generated method stub

	}

	@Override
	public void pause() {
		// Auto-generated method stub

	}

	@Override
	public void resume() {
		// Auto-generated method stub

	}
}
