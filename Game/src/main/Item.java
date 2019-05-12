package main;

/**
 * 
 * This class implements the items that the player will be able to use in the game.
 *
 */
public class Item {
	
	private String name;
	private int value;
	
	/**
	 * Constructor for the Item class.
	 * @param name name of the item
	 * @param value value that the shop will use
	 */
	public Item(String name, int value){
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Uses the item.
	 */
	public void useItem(){
		return;
	}
	
	/**
	 * Buying the item from the shop.
	 */
	public void buyItem(){
		return;
	}
	
	/**
	 * Returns the name of the item.
	 * @return name name of the item
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Returns the value of the item.
	 * @return value value of the item
	 */
	public int getValue(){
		return this.value;
	}
	
	/**
	 * Sets a new value for the item.
	 * @param newValue new value for the item
	 */
	public void setValue(int newValue){
		this.value = newValue;
	}
	
	/**
	 * returns the name of the item.
	 */
	public String toString(){
		return name;
	}
}
