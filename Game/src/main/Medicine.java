package main;

public class Medicine extends Item{
	
	private int healAmount;
	
	public Medicine(String name, int value){
		super(name, value);
		this.healAmount = value;
	}
}
