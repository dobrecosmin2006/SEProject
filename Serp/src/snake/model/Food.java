package snake.model;

public class Food {
	
	// we have 3 types of food 
	// each type have a different score 
	
	public static final int TYPE_1 = 0;
	public static final int TYPE_2 = 1;
	public static final int TYPE_3 = 2;
	
	
	public int x, y;
	public int type;

	
	// simply initiate the food
	
	private void  Food_initiate(int x1, int y1, int type1){
		
		this.x = x1;
		this.y = y1;
		this.type = type1;

	}
	

	public Food(int x, int y, int type) {
		
		Food_initiate(x, y, type);
		
	}
}
