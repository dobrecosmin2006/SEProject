package snake.model;


/*
 *     in this class i will create the Snake
 */

public class Poo extends SnakePart {
	
	
	// put the real timer 
	
	public float timer;
	
	// make some operations with the timer 
	
	public void do_op( float timer1 )
	{
		this.timer = timer1;
	}

	
	public Poo(int x, int y, float timer)
	{
		super(x, y);
		do_op(timer);
	}
	
}
