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
	private int money = 1000;
	
	public Spaceship() {
		crew = new ArrayList<Crew>();
		inventory = new ArrayList<Item>();
	}
	
	/**
	 * Changes the spaceship's name.
	 * @param name name of the spaceship
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * returns the name of the spaceship.
	 * 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Shows the crew member names.
	 */
	public String getCrew() {
		String names = "";
		for(Crew crewMember: crew) {
			names += crewMember.getName() + '\n';
			
		}
		return names;
	}
	
	/**
	 * Returns the number of surviving crew members.
	 * 
	 */
	public int crewLen() {
		return this.crew.size();
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
	public String getInventory(){
		String names = "";
		for (Item item : inventory) {
			names += item.getName() + '\n';
			
		}
		return names;
	}
	
	/**
	 * Changes the amount of money the crew has.
	 * @param money new amount of money
	 */
	public void setMoney(int money) {
		this.money = money;
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
	 * Changes the shield level of the spaceship.
	 * @param shield new shield level of the spaceship
	 */
	public void setShield(int shield) {
		this.shield = shield;
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
	
	/**
	 * Resets the number of actions the crew members can take.
	 */
	public void crewActionReset() {
		for (int i = 0; i < crew.size(); i++) {
			Crew member = crew.get(i);
			member.setActions();
		}
	}
	
	/**
	 * Checks if any of the crew members are sick and does damage if they are.
	 */
	public void sicknessCheck() {
		for (int i = 0; i < crew.size(); i++) {
			Crew member = crew.get(i);
			if (member.getSickness() == true) {
				member.damage(10, this);
			}
		}
	}
	
	/**
	 * Removes the crew member from the crew.
	 * @param member crew member being removed
	 */
	public void removeMember(Crew member) {
		crew.remove(member);
	}
	
	/**
	 * Makes a crew member sick.
	 * @param sickPerson index of the person getting sick
	 */
	public void getSick(int sickPerson) {
		Crew member = crew.get(sickPerson);
		member.sickened();
	}


	public static void main(String[] args) {
		
		Spaceship mySpaceship = new Spaceship();
		mySpaceship.setName("Discovery");
		Gnome bob = new Gnome("bob");
		Gnome joe = new Gnome("joe");
		
		mySpaceship.addCrew(joe);
		mySpaceship.addCrew(bob);
		System.out.print("My Spaceship " + mySpaceship.getName() + " has " + mySpaceship.getShield() + " Shield.\n");
		System.out.print("The Crew are:\n" + mySpaceship.getCrew());
	}
}
