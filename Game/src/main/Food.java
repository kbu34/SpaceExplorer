package main;

/**
 * 
 * This class implements one of the subclasses of Item, Food.
 * 
 *
 */
public class Food extends Item{
	private int nutrition;
	
	/**
	 * Constructor for Food item.
	 * @param name string from a subclass
	 * @param value determines how much hunger consuming the item will get rid of
	 */
	public Food(String name, int value){
		super(name, value);
		this.nutrition = value;
	}
	
	/**
	 * Returns how much hunger the food will fill.
	 *
	 */
	public int getNutrition() {
		return this.nutrition;
	}
}

