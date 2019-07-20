package main;

/**
 * 
 * This class implements one of the subclasses of Crew, Tank.
 *
 */
public class Tank extends Crew {
	
	private static int health = 120;
	private static int shieldRepairValue = 10;
	private static int searchProficiency = 100;
	private static int healthRate = 2;
	private static int tirednessRate = 33;
	private static int itemEffectiveness = 0;
	
	/**
	 * Constructor for Tank.
	 * @param name name of the crew member
	 */
	public Tank(String name) {
		super(name, health, shieldRepairValue, searchProficiency, healthRate, tirednessRate, itemEffectiveness);

	}
}
