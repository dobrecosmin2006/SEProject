package snake.model;

public class SnakePart {
	
	// here I will build and put all parts of my snake 
	
	public int x, y;
	
	public void BuildSnakePart(int x1,int y1){
		
		this.x=x1;
		this.y=y1;
	}
	
	public SnakePart(int x, int y) 
	
	{
		BuildSnakePart(x, y);
	}
}
