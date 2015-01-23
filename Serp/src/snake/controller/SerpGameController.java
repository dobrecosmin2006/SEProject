package snake.controller;

import snake.view.LoadingScreen;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

public class SerpGameController extends Game {

	
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
		
		}
	}
	
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
		// in this method I will start the game
		
		//Start_Game(ok);
		
	}
	
	
	
	

}
