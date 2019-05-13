package main;

/**
 * 
 * This class implements crew members that are playable in the game.
 *
 */
// maybe we also need a method for taking damage?
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
	 * Lets the player view the status of the spaceship.
	 * 
	 */
	public String viewStatus(){
		return;
	}

	/**
	 * Increases the ship's shield level. Decrease member actions by one.
	 */
	public void repair(){
		Spaceship.shield += this.shieldRepairValue;
		this.actions -= 1;
		return;
	}
	
	/**
	 * Sends a crew member for searching. Decrease member actions by one.
	 * 
	 * A crew member may find food or medical item, transporter part, money or nothing
	 */
	public void search(){
		
		this.actions -= 1;
		return;
	}
	
	/**
	 * Changes the location of the spaceship. Decrease member actions by one.
	 * 
	 * Two crew members are required, set piloting of the two crew members to true and decrease action count, change location.
	 */
	public void pilot(){
		return;
	}
	
	/**
	 * Decrease tiredness of the member. Decrease member actions by one.
	 */
	public void sleep(){
		
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
	 * Returns health.
	 * @return health
	 */
	public int getHealth(){
		return health;
	}
	
	/**
	 * sets crew member health according to value.
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
}


