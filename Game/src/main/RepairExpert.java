package main;

/**
 * 
 * This class implements one of the subclasses of Crew, repair expert. 
 *
 */
public class RepairExpert extends Crew {
	
	private static int health = 100;
	private static int shieldRepairValue = 15;
	private static int searchProficiency = 100;
	private static int healthRate = 1;
	private static int tirednessRate = 33;
	private static int itemEffectiveness = 0;
	
	/**
	 * Constructor for RepairExpert.
	 */
	public RepairExpert(String name) {
		super(name, health, shieldRepairValue, searchProficiency, healthRate, tirednessRate, itemEffectiveness);

	}

}
