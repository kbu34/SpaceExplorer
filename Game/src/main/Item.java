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
	 * @param member crew member using the item
	 * @param mySpaceship the spaceship that has the item
	 */
	public void useItem(Crew member, Spaceship mySpaceship){
		if (this instanceof Food) {
			Food food = (Food) this;
			if (member.getHunger() - food.getNutrition() - member.getItemEffetive() < 0) {
				member.setHunger(0);
			} else {
				member.setHunger(member.getHunger() - food.getNutrition() - member.getItemEffetive());
			}
		} else if (this instanceof Medicine) {
			Medicine med = (Medicine) this;
			member.setHealth(member.getHealth() + med.getHeal() + member.getItemEffetive());
			if (this.plagueCuring == true) {
				member.cured();
			}
		}
		mySpaceship.removeItem(this);
	}
	
	/**
	 * Buying the item from the shop.
	 * @param mySpaceship the spaceship the item is going to
	 * @return true if item bought successfully false other wise
	 */
	public boolean buyItem(Spaceship mySpaceship){
		if (this.value < mySpaceship.getMoney()) {
			mySpaceship.setMoney(mySpaceship.getMoney() - this.value);
			mySpaceship.addItem(this);
			return true;
		} else {
			return false;
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
	
}
