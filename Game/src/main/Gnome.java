package main;

public class Gnome extends Crew {
	
	private static int health = 100;
	private static int shieldRepairValue = 10;
	private static int searchProficiency = 100;
	private static int healthRate = 1;
	private static int tirednessRate = 25;
	private static int itemEffectiveness = 0;
	
	public Gnome(String name) {
		super(name, health, shieldRepairValue, searchProficiency, healthRate, tirednessRate, itemEffectiveness);

	}
}
