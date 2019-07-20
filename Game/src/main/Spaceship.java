package main;

import java.util.ArrayList;
import java.util.Scanner;

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
	private int health = 100;
	private int money = 1000;
	Scanner input = new Scanner(System.in);
	
	public Spaceship() {
		crew = new ArrayList<Crew>();
		inventory = new ArrayList<Item>();
	}
	
	/**
	 * Returns the current status of the spaceship.
	 * @return current status of the spaceship.
	 */
	public String getStatus() {
		String shieldStr = Integer.toString(this.shield);
		String healthStr = Integer.toString(this.health);
		String moneyStr = Integer.toString(this.money);
		return "Spaceship name: " + this.name + "\nCurrent shield: " + shieldStr + "\nCurrent health: " + healthStr + "\nCurrent money: " + moneyStr;
	}
	
	public Crew crewGetter(int i) {
		return crew.get(i);
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
	 * @return name of the spaceship
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Shows the crew member names.
	 * @return names of the crew members
	 */
	public String getCrew() {
		String names = "";
		int i = 1;
		for(Crew crewMember: crew) {
			names += i + " = "+ crewMember.getName() + '\n';
			i += 1;
		}
		return names;
	}
	
	/**
	 * Returns the number of surviving crew members.
	 * @return number of crew members
	 */
	public int crewLen() {
		return this.crew.size();
	}
	
	/**
	 * Adds crew member
	 * @param crewMember crew member to be added
	 */
	public void addCrew(Crew crewMember) {
		crew.add(crewMember);
	}
	
	/**
	 * Shows the item inventory.
	 * @return names of the items in the inventory
	 */
	public String getInventory(){
		String names = "";
		for (int i = 0; i < this.lenInventory(); i++) {
			String itemName = this.inventory.get(i).getName();
			String iStr = Integer.toString(i + 1);
			names += iStr + ". " + itemName + "\n";
		}
		return names;
	}
	
	/**
	 * Returns the index of the crew member in the crew list.
	 * @param member crew member being passed to the method
	 * @return index of the crew member in the list added by 1
	 */
	public int crewIndex(Crew member) {
		return this.crew.indexOf(member) + 1;
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
		if (this.shield < 0) {
			this.shield = 0;
		}
	}
	/**
	 * Adds item to the inventory.
	 * @param item the item obtained
	 */
	public void addItem(Item item){
		this.inventory.add(item);
	}
	
	/**
	 * Remove to from the inventory.
	 * @param item the item used or lost
	 */
	public void removeItem(Item item){
		this.inventory.remove(item);
	}
	
	/**
	 * Shows the size of the inventory.
	 * @return number of items in the inventory
	 */
	public int lenInventory() {
		return this.inventory.size();
	}
	
	/**
	 * Returns the item in inventory.
	 * @param i the index specified  
	 * @return the item specified
	 */
	public Item inventoryGetter(int i) {
		System.out.println(this.inventory.get(i));
		return this.inventory.get(i);
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
	
	/**
	 * Sets the health of the spaceship according to change
	 * @param healthChange Change to health calculated.
	 */
	public void setHealth(int healthChange) {
		this.health = healthChange;
	}
	
	/**
	 * Returns the health of the spaceship.
	 * @return The health of the spaceship.
	 */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * A Space outpost where the player can visit and purchase items.
	 * @param itemNum The number of item the player buys.
	 */
	public void outpost(int itemNum) {
		System.out.println("Items for sale:");
		System.out.println("1.Pizza (Effect: reduces hunger by 20. Price: 20");
		System.out.println("2.Diazepam (Effect: heals user by 20. Price: 20");
		System.out.println("3.Plague Medicine (Effect: cures space plague. Price: 50");
		System.out.println("Current inventory:");
		for (Item mainItem : this.inventory) {
			int count = 0;
			for (Item item : this.inventory) {
				if (mainItem == item) {
					count += 1;
				}
			}
			System.out.println(mainItem.getName() + ": " + count);
		}
		System.out.println("Money: " + money);
		System.out.println("Which item would you like to buy?(enter any other number to exit");
		int order = itemNum;
		if (order == 1) {
			Pizza pizza = new Pizza();
			pizza.buyItem(this);
		} else if (order == 2) {
			Diazepam diazepam = new Diazepam();
			diazepam.buyItem(this);
		} else if (order == 3) {
			PlagueMedicine plagueMedicine = new PlagueMedicine();
			plagueMedicine.buyItem(this);
		}
	}
	
	/**
	 * Returns the crew member in the list of crew members.
	 * @param i index of the crew member in the crew ArrayList
	 * @return the crew member in the ArrayList specified by the index
	 */
	public Crew getCrewMember(int i) {
		return this.crew.get(i);
	}
}
