package main;

/**
 * 
 * This class implements one of the subclasses of Item, Medicine.
 *
 */
public class Medicine extends Item{
	
	private int healAmount;
	
	/**
	 * Constructor for the Medicine item.
	 * @param name the name of the medicine
	 * @param value the value of the medicine
	 */
	public Medicine(String name, int value) {
		super(name, value);
		this.healAmount = value;
	}
	
	/**
	 * Returns healing amount of medicine.
	 * 
	 */
	public int getHeal() {
		return this.healAmount;
	}
}
