package snake.model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	
	//sens trigonometric 
	
	public static final int UP = 0;
	public static final int LEFT = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	
	//creez un Array List de parti ale sarpelui

	public List<SnakePart> parts = new ArrayList<SnakePart>();
	
	public int direction;

	public void Add_Parts()
	{
		
		
		parts.add(new SnakePart(2, 4));
		parts.add(new SnakePart(2, 5));
		parts.add(new SnakePart(2, 6));
		parts.add(new SnakePart(2, 7));
		
	}
	
	public Snake() {
		
		direction = RIGHT;
		Add_Parts();
		
	}

	/*
	 * Move
	 */
	
	
	// aici coteste SNAKE-ul :)  I want to do it from keyboard 
	
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
	 * Others
	 */
	public void grow() 
	{
		
		SnakePart end = parts.get(parts.size() - 1);
		parts.add(new SnakePart(end.x, end.y));
	}

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
