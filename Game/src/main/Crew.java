package main;

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
	boolean sick;//are these two variables not meant to be private?
	boolean piolting;
	private int hunger;
	private int hungerRate;
	private int healthrate;
	private int tirednessRate;
	private int itemEffectiveness;
	private int actions;
	
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
		shieldRepairValue += 1;
		return;
	}
	
	/**
	 * Sends a crew member for searching. Decrease member actions by one.
	 * 
	 * A crew member may find food or medical item, transporter part, money or nothing
	 */
	public void search(){
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
		return;
	}
	
	/**
	 * Let the player choose what item to use, use the item. Decrease member actions by one.
	 */
	public void consumeItem(){
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
