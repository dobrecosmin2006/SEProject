package snake.model;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import snake.model.Snake;
import snake.view.GameScreen;


// class for Input Keyboard to get left, right, up or down 

public class KeyInput extends KeyAdapter {
	
	
	GameScreen Game;
	
	public KeyInput(GameScreen gameScreen){
		
		this.Game=gameScreen;
		
	}

	public void keyPressed(KeyEvent e){
		
		Game.keyPressed(e);
		
	}
	
	public void keyReleased(KeyEvent e){
		
		Game.keyReleased(e);
		
	}
	

}
