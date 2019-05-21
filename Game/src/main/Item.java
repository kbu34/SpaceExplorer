package main;

/**
 * 
 * This class implements the items that the player will be able to use in the game.
 *
 */
public class Item {
	
	private String name;
	private int value;
	private boolean plagueCuring;
	private Spaceship mySpaceship;
	
	/**
	 * Constructor for the Item class.
	 * @param name name of the item
	 * @param value value that the shop will use
	 */
	public Item(String name, int value){
		this.name = name;
		this.value = value;
		if (this instanceof PlagueMedicine) {
			this.plagueCuring = true;
		} else {
			this.plagueCuring = false;
		}
	}
	
	/**
	 * Uses the item.
	 */
	public void useItem(Crew member){
		if (this instanceof Food) {
			Food food = (Food) this;
			member.setHunger(member.getHunger() + food.getNutrition());
		} else if (this instanceof Medicine) {
			Medicine med = (Medicine) this;
			member.setHealth(member.getHealth() - med.getHeal());
			if (this.plagueCuring == true) {
				member.cured();
			}
		}
		mySpaceship.removeItem(this);
	}
	
	/**
	 * Buying the item from the shop.
	 */
	public void buyItem(){
		if (this.value < mySpaceship.getMoney()) {
			mySpaceship.setMoney(mySpaceship.getMoney() - this.value);
			mySpaceship.addItem(this);
		}
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
