package main;

public class Item {
	
	private String name;
	private int value;
	
	public Item(String name, int value){
		this.name = name;
		this.value = value;
	}
	
	public void useItem(){
		return;
	}
	
	public void buyItem(){
		return;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int newValue){
		this.value = newValue;
	}
	
	public String toString(){
		return name;
	}
}
