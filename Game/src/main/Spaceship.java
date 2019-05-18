package main;

import java.util.ArrayList;

/**
 * 
 * This class implements the spaceship and the inventory the player will use
 *
 */
public class Spaceship {
	private String name;
	private ArrayList<Crew> crew;
	private ArrayList<Item> inventory;
	private int shield = 100;
	private int money;
	
	public Spaceship(String name) {
		this.name = name;
		crew = new ArrayList<Crew>();
		inventory = new ArrayList<Item>();
	}
	
	public String getName() {
		return this.name;
	}
	/**
	 * Shows the crew member status.
	 */
	public String getCrew(){
		String names = "";
		for(Crew crewMember: crew) {
			names += crewMember.getName() + '\n';
			
		}
		return names;
	}
	
	/**
	 * Adds crew member
	 * @param crew member to be added
	 */
	public void addCrew(Crew crewMember) {
		crew.add(crewMember);
	}
	
	/**
	 * Shows the item inventory.
	 */
	public void getInventory(){
		return;
	}
	
	/**
	 * Shows the amount of money the player has.
	 * @return money player's money
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * Shows the spaceship's shield level.
	 * @return shield the spaceship's shield level
	 */
	public int getShield(){
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
	public void removeItem(Item item){
		inventory.remove(item);
	}
	
	/**
	 * Shows the size of the inventory.
	 */
	public int lenInventory() {
		return inventory.size();
	}
	
	/**
	 * Returns the item in inventory.
	 * @param i the index specified  
	 */
	public Item inventoryGetter(int i) {
		return inventory.get(i);
	}

	public static void main(String[] args) {
		
		Spaceship mySpaceship = new Spaceship("Discovery");
		Gnome bob = new Gnome("bob");
		Gnome joe = new Gnome("joe");
		
		mySpaceship.addCrew(joe);
		mySpaceship.addCrew(bob);
		System.out.print("My Spaceship " + mySpaceship.getName() + " has " + mySpaceship.getShield() + " Shield.\n");
		System.out.print("The Crew are:\n" + mySpaceship.getCrew());
	}
}
