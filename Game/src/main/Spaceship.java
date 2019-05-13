package main;

import java.util.ArrayList;

/**
 * 
 * This class implements the spaceship and the inventory the player will use
 *
 */
public class Spaceship {
	private ArrayList<Crew> crew;
	private static ArrayList<Item> inventory;
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
		inventory.add(item);
	}
	
	/**
	 * Remove to from the inventory.
	 * @param item the item used or lost
	 */
	public static void removeItem(Item item){
		inventory.remove(item);
	}
	
	/**
	 * Shows the size of he inventory.
	 */
	public static int lenInventory() {
		return inventory.size();
	}
	
	/**
	 * Returns the item in inventory.
	 * @param i the index specified  
	 */
	public static Item inventoryGetter(int i) {
		return inventory.get(i);
	}
}
