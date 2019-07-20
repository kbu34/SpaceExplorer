package main;

/**
 * 
 * This class implements one of the subclasses of Crew, consumer. 
 *
 */
public class Consumer extends Crew {
	
	private static int health = 100;
	private static int shieldRepairValue = 10;
	private static int searchProficiency = 100;
	private static int healthRate = 2;
	private static int tirednessRate = 33;
	private static int itemEffectiveness = 2;
	
	/**
	 * Constructor for Consumer.
	 * @param name name of the crew member
	 */
	public Consumer(String name) {
		super(name, health, shieldRepairValue, searchProficiency, healthRate, tirednessRate, itemEffectiveness);

	}

}
