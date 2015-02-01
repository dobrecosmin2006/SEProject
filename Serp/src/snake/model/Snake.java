package snake.model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	
	//counter clock direction  
	
	public static final int UP = 0;
	public static final int LEFT = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	
	//creez un Array List for snakeparts

	public List<SnakePart> parts = new ArrayList<SnakePart>();
	
	public int direction;

	// at run, snake will have 4 elements of the tail 
	
	public void Add_Parts()
	{
		
		
		parts.add(new SnakePart(2, 4));
		parts.add(new SnakePart(2, 5));
		parts.add(new SnakePart(2, 6));
		parts.add(new SnakePart(2, 7));
		
	}
	
	public Snake() {
		
		// the start direction is to RIGHT 
		
		int ok = 1;
		if ( ok == 1 )
		{
			direction = RIGHT;
			
		}
		else if ( ok == 2 ) 
		{
			direction = UP;
		
		}
		else if ( ok == 3 ){
			
			direction = DOWN;
		}
		else {
			
			direction = LEFT;
		}
		Add_Parts();
		
	}

	/*
	 * Move
	 */
	
	
	// take some turns SNAKE-ul :)  I want to do it also from keyboard 
	
	public void turnLeft() {
		
		direction += 1;
		if (direction > RIGHT)
			direction = UP;
	}

	public void turnRight() {
		
		direction -= 1;
		if (direction < UP)
			direction = RIGHT;
	}
	
	// check if the snake will go out from the table -> left , right, etc

	public int Capat_X(int head1)
	{
		if (head1 < 0)
			head1 = 9;
	
		if (head1 > 9)
			head1 = 0;
		
		return head1;
		
	}
	
	public int Capat_Y(int heady){
		
		if (heady < 2)
			heady = 14;
		
		if (heady > 14)
			heady = 2;
		
		return heady;
		
	}
	
	// this is the main function for my snake to advance 
	
	public void advance() {

		SnakePart head = parts.get(0);

		int len = parts.size() - 1;
		for (int i = len; i > 0; i--) 
		{
			SnakePart before = parts.get(i - 1);
			SnakePart part = parts.get(i);
			
			part.x = before.x;
			part.y = before.y;
		}

		switch(direction)
		{
			case UP: head.y += 1;break;
			case DOWN:head.y -= 1;break;
			case RIGHT:head.x += 1;break;
			case LEFT :head.x -= 1;break;
			default:break;
			
		}
		
		
		head.x=Capat_X(head.x);
		head.y=Capat_Y(head.y);
		
	}

	/*
	 * this function is for growing up of the snake when it will eat smth
	 */
	public void grow() 
	{
		
		SnakePart end = parts.get(parts.size() - 1);
		parts.add(new SnakePart(end.x, end.y));
	}
	
	// i will check what I have eaten

	public boolean checkBitten() {
		
		int len = parts.size();
		SnakePart head = parts.get(0);
		for (int i = 1; i < len; i++) {
			SnakePart part = parts.get(i);
			if (part.x == head.x && part.y == head.y)
				return true;
		}
		return false;
	}

	// methods for my keyboard pressed
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int key = e.getKeyCode();
		if( key == KeyEvent.VK_RIGHT){
			
			direction -= 1;
			if (direction < UP)
				direction = RIGHT;
			
		}
		else if( key == KeyEvent.VK_LEFT){
				
			direction += 1;
			if (direction > RIGHT)
				direction = UP;
		}
		else
		{
			
		}
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int key = e.getKeyCode();
         if( key == KeyEvent.VK_RIGHT){
			
			
			if (direction < UP)
				direction = RIGHT;
			
		}
		else if( key == KeyEvent.VK_LEFT){
				
			
			if (direction > RIGHT)
				direction = UP;
		}
		else
		{
			
		}
	}
}
