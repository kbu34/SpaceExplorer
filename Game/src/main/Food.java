package main;

public class Food extends Item{
	private int nutrition;
	
	public Food(String name, int value){
		super(name, value);
		this.nutrition = value;
	}
}

