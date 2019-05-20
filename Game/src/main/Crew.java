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
	private boolean piolting;
	private int hunger;
	private int hungerRate;
	private int healthRate;
	private int tirednessRate;
	private int itemEffectiveness;
	private int actions;
	

	/**
	 * Constructor for the Crew class.
	 * @param name name of the crew member
	 * @param health health of the crew member
	 * @param shieldRepairValue value of how much shield a crew member can repair at a time
	 * @param searchProficiency value of how good a crew member is at searching for items
	 * @param healthRate 
	 * @param tirednessRate
	 * @param itemEffectiveness
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
		this.piolting = false;
		this.actions = 2;
	
	}
	
	/**
	 * Lets the player view the status of the spaceship and crew members.
	 * 
	 */
	public String viewStatus(){
		String stringHealth = Integer.toString(this.health);
		String stringHunger = Integer.toString(this.hunger);
		String stringSick = Boolean.toString(this.sick);
		String stringActions = Integer.toString(this.actions);
		return "Crew member name: " + this.name + "\nCurrent health: " + stringHealth + "\nCurrent hunger: " + stringHunger + "\nCurrently sick: " + stringSick + "\nActions left: " + stringActions;
	}

	/**
	 * Increases the ship's shield level. Decrease member actions by one.
	 */
	public void repair(Spaceship mySpaceship){
		mySpaceship.setShield(mySpaceship.getShield() + this.shieldRepairValue);
		this.actions -= 1;
		return;
	}
	
	/**
	 * Sends a crew member for searching. Decrease member actions by one.
	 * 
	 * A crew member may find food or medical item, transporter part, money or nothing
	 */
	public void search(Spaceship mySpaceship, Game game){
		Random rand = new Random();
		int i = rand.nextInt(20);
		if (i == 1) {
			mySpaceship.setMoney(mySpaceship.getMoney() + 99999);
		} else if (i == 2 || i == 3) {
			Pie pie = new Pie();
			mySpaceship.addItem(pie);
			System.out.println("pie found");
		} else if (i == 4 || i == 5) {
			Apple apple = new Apple();
			mySpaceship.addItem(apple);
			System.out.println("apple found");
		} else if (i == 6) {
			PorkChops porkChops = new PorkChops();
			mySpaceship.addItem(porkChops);
			System.out.println("pork chops found");
		} else if (i == 7) {
			Paracetamol paracetamol = new Paracetamol();
			mySpaceship.addItem(paracetamol);
			System.out.println("paracetamol found");
		} else if (i == 8 || i == 9 || i == 10) {
			Codeine codeine = new Codeine();
			mySpaceship.addItem(codeine);
			System.out.println("codeine found");
		} else if (game.getPartFound() == true && i == 9 || i == 10 || i == 11) {
			game.partFound();
			System.out.println("transporter piece found");
		} else {
			System.out.println("you found nothing");
		}
		this.actions -= 1;
		return;
	}
	
	/**
	 * Changes the location of the spaceship. Decrease member actions by one.
	 * 
	 * Two crew members are required, set piloting of the two crew members to true and decrease action count, change location.
	 */
	public void pilot(Crew other, Game game){
		game.nextPlanet();
		this.actions -= 1;
		other.actions -= 1;
	}
	
	/**
	 * Decrease tiredness of the member. Decrease member actions by one.
	 */
	public void sleep(){
		this.tiredness -= 10;
		this.actions -= 1;
		return;
	}
	
	/**
	 * Let the player choose what item to use, use the item. Decrease member actions by one.
	 */
	public void consumeItem(){
		
		this.actions -= 1;
		return;
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
	 * 
	 */
	public boolean getSickness() {
		return this.sick;
	}
	
	/**
	 * Returns health.
	 * @return health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Does damage to a crew member.
	 * They die if their health drops below 0.
	 * @param damage damage taken by crew member
	 * @param mySpaceship the spaceship
	 */
	public void damage(int damage, Spaceship mySpaceship) {
		this.health -= damage;
		if (this.health > 0) {
			mySpaceship.removeMember(this);
			System.out.println(this.name + " died.");
		}
	}
	
	/**
	 * Sets crew member health according to value.
	 * @param value the health value given
	 */
	public void setHealth(int value){
		this.health = value;
		return;
	}
	
	/**
	 * Returns tiredness of the crew member.
	 * @return tiredness tiredness of the crew member
	 */
	public int getFatigue(){
		return tiredness;
	}
	
	/**
	 * Sets the tiredness of the crew member.
	 * @param value the tiredness value given.
	 */
	public void setTiredness(int value){
		this.tiredness = value;
		return;
	}
	
	/**
	 * Sets the number of actions a crew member can take per day, which is always 2.
	 */
	public void setActions() {
		this.actions = 2;
	}
	
	/**
	 * Returns the number of actions a crew member has left.
	 * @return
	 */
	public int getActions() {
		return this.actions;
	}
	
	/**
	 * Returns the crew member's name.
	 * @return
	 */
	public String getName() {
		return this.name;
	}
}


