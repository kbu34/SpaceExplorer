package main;

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
	
	public String viewStatus(){
		return;
	}
	
	public void repair(){
		//increase the ship's shield level
		return;
	}
	
	public void search(){
		//a crew member may find food or medical item, transporter part, money or nothing
		return;
	}
	
	public void pilot(){
		//two crew members are needed, set piloting of the two crew members to true and decrese action count, change location
		return;
	}
	
	public void sleep(){
		//decrease tiredness
		return;
	}
	
	public void consumeItem(){
		//let the player choose what item to use, use the item
		return;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int value){
		this.health = value;
		return;
	}
	
	public int getFatigue(){
		return tiredness;
	}
	
	public void setFatigue(int value){
		this.tiredness = value;
		return;
	}
	
	public void setActions() {
		this.actions = 2;
	}
}
