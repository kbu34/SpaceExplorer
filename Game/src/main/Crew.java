package main;

import java.util.Random;

/**
 * 
 * This class implements crew members that are playable in the game.
 *
 */
public class Crew {
	private int health;
	private int shieldRepairValue;
	private int searchProficiency;
	private String name;
	private int tiredness;
	private boolean sick;
	private boolean piloting;
	private int hunger;
	private int hungerRate;
	private int healthRate;
	private int tirednessRate;
	private int itemEffectiveness;
	private int actions;
	private int e;
	

	/**
	 * Constructor for the Crew class.
	 * @param name name of the crew member
	 * @param health health of the crew member
	 * @param shieldRepairValue value of how much shield a crew member can repair at a time
	 * @param searchProficiency value of how good a crew member is at searching for items
	 * @param healthRate value of how much additional health the crew member recovers when healing
	 * @param tirednessRate value of how fast the crew member gets tired
	 * @param itemEffectiveness value of how much effect items have on the crew member
	 */
	public Crew(String name, int health, int shieldRepairValue, int searchProficiency, int healthRate, int tirednessRate, int itemEffectiveness) {
		
		this.name = name;
		this.health = health;
		this.shieldRepairValue = shieldRepairValue;
		this.searchProficiency = searchProficiency;
		this.healthRate = healthRate;
		this.tirednessRate = tirednessRate;
		this.itemEffectiveness = itemEffectiveness;
		this.hungerRate = 3;
		this.tiredness = 0;
		this.hunger = 0;
		this.sick = false;
		this.piloting = false;
		this.actions = 2;
	
	}
	
	/**
	 * Lets the player view the status of the spaceship and crew members.
	 * @return status
	 */
	public String viewStatus(){
		String stringHealth = Integer.toString(this.health);
		String stringHunger = Integer.toString(this.hunger);
		String stringSick = Boolean.toString(this.sick);
		String stringActions = Integer.toString(this.actions);
		return "Crew member name: " + this.name + "\nCurrent health: " + stringHealth + "\nCurrent hunger: " + stringHunger + "\nCurrently sick: " + stringSick + "\nActions left: " + stringActions + "\n";
	}

	/**
	 * Increases the ship's shield level. Decrease member actions by one.
	 * @param mySpaceship the spaceship
	 */
	public void repair(Spaceship mySpaceship){
		mySpaceship.setShield(mySpaceship.getShield() + this.shieldRepairValue);
		this.actions -= 1;
	}
	
	/**
	 * Sends a crew member for searching. Decrease member actions by one.
	 * A crew member may find food or medical item, transporter part, money or nothing
	 * @return description of the item found
	 * @param mySpaceship the spaceship
	 * @param game current game
	 */
	public String search(Spaceship mySpaceship, Game game){
		String found = "";
		if (this.actions > 0) {
			Random rand = new Random();
			if (this instanceof SearchExpert) {
				this.e = rand.nextInt(13);
			} else {
				this.e = rand.nextInt(20);
			}
			int i = this.e;
			if (i == 1) {
				mySpaceship.setMoney(mySpaceship.getMoney() + 99999);
			} else if (i == 2 || i == 3) {
				Pie pie = new Pie();
				mySpaceship.addItem(pie);
				System.out.println("pie found");
				found = "Pie found";
			} else if (i == 4 || i == 5) {
				Apple apple = new Apple();
				mySpaceship.addItem(apple);
				System.out.println("apple found");
				found = "apple found";
			} else if (i == 6) {
				PorkChops porkChops = new PorkChops();
				mySpaceship.addItem(porkChops);
				System.out.println("pork chops found");
				found = "Pork chops found";
			} else if (i == 7) {
				Paracetamol paracetamol = new Paracetamol();
				mySpaceship.addItem(paracetamol);
				System.out.println("paracetamol found");
				found = "Paracetamol found";
			} else if (i == 8 || i == 9 || i == 10) {
				Codeine codeine = new Codeine();
				mySpaceship.addItem(codeine);
				System.out.println("codeine found");
				found = "Codeine found";
			} else if (game.getPartFound() == false && i == 9 || i == 10 || i == 11 || i == 12) {
				game.partFound();
				System.out.println("transporter piece found");
				found = "Transporter Piece found!";
			} else {
				System.out.println("you found nothing");
				found = "You found nothing";
			}
			this.actions -= 1;
		} else {
			System.out.println("This crew member has no actions left.");
			found = "This crew member has no actions left.";
		}
		return found;
	}
	
	/**
	 * Changes the location of the spaceship. Decrease member actions by one.
	 * Two crew members are required, set piloting of the two crew members to true and decrease action count, change location.
	 * @param other the other co-pilot
	 * @param game current game
	 */
	public void pilot(Crew other, Game game){
		if (this.actions > 0 && other.actions > 0) {
			game.nextPlanet();
			this.actions -= 1;
			other.actions -= 1;
		} else {
			System.out.println("At least one of the pilots have no actions left.");
		}
	}
	
	/**
	 * Decrease tiredness of the member. Decrease member actions by one.
	 */
	public void sleep(){
		if (this.actions > 0) {
			this.tiredness -= 40;
			if (this.tiredness < 0) {
				this.tiredness = 0;
			}
			this.actions -= 1;
		} else {
			System.out.println("This crew member has no actions left.");
		}
	}
	
	/**
	 * Let the player choose what item to use, use the item. Decrease member actions by one.
	 * @param item the item selected
	 * @param mySpaceship the spaceship
	 */
	public void consumeItem(Item item, Spaceship mySpaceship) {
		if (this.actions > 0) {
			item.useItem(this, mySpaceship);
			this.actions -= 1;
		} else {
			System.out.println("This crew member has no actions left.");
		}
	}
	
	/**
	 * Makes a crew member sick'
	 */
	public void sickened() {
		this.sick = true;
	}
	
	/**
	 * Cures a crew member from space plague.
	 */
	public void cured() {
		this.sick = false;
	}
	
	/**
	 * Checks if a crew member is sick.
	 * @return if the crew member is sick or not
	 */
	public boolean getSickness() {
		return this.sick;
	}
	
	/**
	 * Returns health.
	 * @return health
	 */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * Returns item effectiveness.
	 * @return item effectiveness of the crew member.
	 */
	public int getItemEffetive() {
		return this.itemEffectiveness;
	}
	
	/**
	 * Does damage to a crew member.
	 * Crew members die if their health drops below 0.
	 * @param damage damage taken by crew member
	 * @param mySpaceship the spaceship
	 */
	public void damage(int damage, Spaceship mySpaceship) {
		this.health -= damage;
		if (this.health <= 0) {
			mySpaceship.removeMember(this);
			System.out.println(this.name + " died.");
			DeathAlertGUI deathGUI = new DeathAlertGUI(this.name);
		}
	}
	
	/**
	 * Sets crew member health according to value.
	 * @param value the health value given
	 */
	public void setHealth(int value){
		this.health = value;
	}
	
	/**
	 * Returns tiredness of the crew member.
	 * @return tiredness tiredness of the crew member
	 */
	public int getTiredness(){
		return tiredness;
	}
	
	/**
	 * Sets the tiredness of the crew member.
	 * @param value the tiredness value given.
	 */
	public void setTiredness(int value){
		this.tiredness = value;
		if (this.tiredness < 0) {
			this.tiredness = 0;
		}
	}
	
	/**
	 * Sets the number of actions a crew member can take per day, which is always 2.
	 */
	public void setActions() {
		this.actions = 2;
	}
	
	/**
	 * Returns the number of actions a crew member has left.
	 * @return the number of actions left of the crew member
	 */
	public int getActions() {
		return this.actions;
	}
	
	/**
	 * Returns the crew member's name.
	 * @return the name of the crew member
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * returns the hunger level of the crew member.
	 * @return The hunger level of the crew member.
	 */
	public int getHunger() {
		return this.hunger;
	}
	
	/**
	 * Sets the crew member's hunger level according to change.
	 * @param newHunger The new hunger level calculated.
	 */
	public void setHunger(int newHunger) {
		this.hunger = newHunger;
	}
}


