package main;

/**
 * 
 * This class implements one of the subclasses of Crew, search expert. 
 *
 */
public class SearchExpert extends Crew {
	
	private static int health = 100;
	private static int shieldRepairValue = 10;
	private static int searchProficiency = 120;
	private static int healthRate = 2;
	private static int tirednessRate = 33;
	private static int itemEffectiveness = 0;
	
	/**
	 * Constructor for SearchExpert.
	 */
	public SearchExpert(String name) {
		super(name, health, shieldRepairValue, searchProficiency, healthRate, tirednessRate, itemEffectiveness);

	}

}
