package main;

import java.util.ArrayList;

/**
 * 
 * This class implements the spaceship and the inventory the player will use
 *
 */
public class Spaceship {
	private ArrayList<Crew> crew;
	private ArrayList<Item> inventory;
	private int shield;
	private int money;
	
	/**
	 * Shows the crew member status.
	 */
	public void viewCrew(){
		return;
	}
	
	/**
	 * Shows the item inventory.
	 */
	public void viewInventory(){
		return;
	}
	
	/**
	 * Shows the amount of money the player has.
	 * @return money player's money
	 */
	public int viewMoney(){
		return money;
	}
	
	/**
	 * Shows the spaceship's shield level.
	 * @return shield the spaceship's shield level
	 */
	public int viewShield(){
		return shield;
	}
	
	/**
	 * Adds item to the inventory.
	 * @param item the item obtained
	 */
	public void addItem(Item item){
		return;
	}
	
	/**
	 * Remove to from the inventory.
	 * @param item the item used or lost
	 */
	public void removeItem(Item item){
		return;
	}
}
