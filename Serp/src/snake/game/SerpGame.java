package snake.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

import snake.view.LoadingScreen;

public class SerpGame extends Game {

	AssetManager assets;
	public int ok =1;

	// I am testing this application

	public void Start_Game (int ok)
	{
		if (ok ==1 ) {
			
			Gdx.app.setLogLevel(Application.LOG_ERROR);
			Gdx.app.error("Snake-CatchTheWorms", "create(), setLogLevel(LOG_error)");
			Gdx.app.log("Snake-CatchTheWorms", "create(), going to LoadingScreen");
			setScreen(new LoadingScreen(this, assets));
			Gdx.app.log("Snake-CatchTheWorms", "ended create()");
			
		}
		else
		{
			//it is a problem with the game :-)
            // and it will  not start
		
		}
	}

	@Override
	public void create() 
	{
		
		Start_Game(ok);	
	}

}
