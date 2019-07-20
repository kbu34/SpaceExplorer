package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * This class implements the events in the game.
 *
 */
public class Game {
	private int spaceshipLocation = 1;
	private int gameLength;
	private int turnNum;
	private int totalParts;
	private int partsAquired;
	private boolean partFoundHere;
	private Spaceship mySpaceship;
	private Crew member;
    private Scanner input = new Scanner(System.in);
    private Random rand = new Random();
    private MainGameGUI gameGUI;
	
	/**
	 * Starts the game.
	 * @param days number of days the player wants to play
	 * @param crewNum the number of crew members
	 * @param typeList the Array of types of crew members
	 * @param nameList the Array of names of the crew members
	 * @param shipName the name of the spaceship
	 */
	public void startGame(int days, int crewNum, ArrayList<Integer> typeList, ArrayList<String> nameList, String shipName) {
		System.out.println("How many days would you like the game to last?");
		gameLength = days;
		double doubleLength = gameLength;
		double doubleParts = (doubleLength / 3) * 2;
		totalParts = (int) doubleParts;
		System.out.println(totalParts);
		mySpaceship = new Spaceship();
		System.out.println("Enter the number of crew(2-4)");
		while(crewNum != 0) {
			pickCrew(typeList.get(crewNum - 1), nameList.get(crewNum - 1));
			crewNum -= 1;
		}
		System.out.println("Enter a name for your spaceship");
		mySpaceship.setName(shipName);
		partsAquired = 0;
		turnNum = 1;
		spaceshipLocation = 1;
		partFoundHere = false;
		launchMainScreen();
	}
	
	/**
	 * Returns total transporter parts needed.
	 * @return the number of total transporter parts needed
	 */
	public int getTotalParts() {
		return this.totalParts;
	}
	
	/**
	 * Returns total transporter parts aquired so far.
	 * @return the number of transporter parts aquired so far
	 */
	public int getPartsAquired() {
		return this.partsAquired;
	}
	
	/**
	 * Returns the current turn number.
	 * @return current turn number
	 */
	public int getTurnNum() {
		return this.turnNum;
	}
	
	/**
	 * Returns the total length of game.
	 * @return total length of game
	 */
	public int getGameLen() {
		return this.gameLength;
	}
	
	/**
	 * Starts the setup GUI window.
	 */
	public void launchOpeningScreen() {
		GameGUI gameGUI = new GameGUI(this);
	}
	
	/**
	 * Starts the main game GUI window.
	 */
	public void launchMainScreen() {
		gameGUI = new MainGameGUI(this, mySpaceship);
	}
	
	/**
	 * Lets the user pick the crew member they want.
	 * @param type the type of the crew member the player wants
	 * @param memberName the name of the crew member
	 */
	public void pickCrew(int type, String memberName) {
		System.out.println("Enter the type of crew member you want");
		System.out.println("1 = Tank - has more health");
		System.out.println("2 = Consumer - Benefits more from items");
		System.out.println("3 = Repair Expert - better at repairing the ship");
		System.out.println("4 = Search Expert - better at searching");
		System.out.println("5 = Gnome - immune to plague?");
		System.out.println("6 = Insomniac - Needs less sleep");

		int crewNum = type;
		System.out.println("Enter the crew member's name");
		String name = memberName;
		if (crewNum == 1) {
			member = new Tank(name);
		} else if (crewNum == 2) {
			member = new Consumer(name);
		} else if (crewNum == 3) {
			member = new RepairExpert(name);
		} else if (crewNum == 4) {
			member = new SearchExpert(name);
		} else if (crewNum == 5) {
			member = new Gnome(name);
		} else if (crewNum == 6) {
			member = new Insomniac(name);
		} else {
			throw new IllegalArgumentException("pick from 1 to 6");
		}
		System.out.println(member.getName());
		mySpaceship.addCrew(member);
		member.setActions();
	}

	/**
	 * Sick crew members will take damage and action count will be reset for all remaining crew members.
	 */
	public void nextTurn() {
		mySpaceship.sicknessCheck();
		mySpaceship.crewActionReset();
		System.out.println("day:");
		System.out.println(this.turnNum);
		System.out.println(this.gameLength);
		System.out.println("time given:");
		if (this.turnNum == this.gameLength) {
			gameOver();
		} else {
			this.turnNum += 1;
		}
		for (int i = 0; i < mySpaceship.crewLen(); i++) {
			Crew member = mySpaceship.crewGetter(i);
			member.setHunger(member.getHunger() + 25);
			if (member instanceof Insomniac) {
				member.setTiredness(member.getTiredness() + 20);
			} else {
				member.setTiredness(member.getTiredness() + 35);
			}
		}
		eventPicker();
	}
	
	/**
	 * Pick an event by random, the player should be alerted of the event.
	 */
	public void eventPicker() {
		int e = rand.nextInt(10);
		System.out.print("EVENT");
		System.out.print(e);
		if (e == 1 || e == 2) {
			pirates();
		} else if (e == 3 || e == 4) {
			plague();
		}
	}
	
	/**
	 * Decreases shield level of the ship. The ship also takes damage.
	 */
	public void astroidBelt() { 
		int e = rand.nextInt(10);
		if (e > 7) {
			int damage = 700;
			System.out.println("Going though an astoid belt");
			int currentShield = mySpaceship.getShield();
			damage = (damage - (currentShield * 5));
			mySpaceship.setHealth(mySpaceship.getHealth() - damage);
			if (mySpaceship.getHealth() <= 0) {
				gameOver();
			} else {
				mySpaceship.setShield(mySpaceship.getShield() - 35);
				AstroidAlertGUI alertGUI = new AstroidAlertGUI(damage, mySpaceship);
			}
		}
	}
	
	/**
	 * Removes random item.
	 */
	public void pirates() {
		System.out.println("pirate invasion");
		System.out.println(this.mySpaceship.lenInventory());
		if (this.mySpaceship.lenInventory() != 0) {
			int i = rand.nextInt(this.mySpaceship.lenInventory());
			PirateAlertGUI pirateGUI = new PirateAlertGUI(this.mySpaceship.inventoryGetter(i));
			this.mySpaceship.removeItem(this.mySpaceship.inventoryGetter(i));
		}
	}
	
	/**
	 * Makes one or more crew members sick, sick crew members lose health everyday until cured with medicine.
	 */
	public void plague() {
		System.out.println("space plague");
		for (int i = 0; i < mySpaceship.crewLen(); i++) {
			int e = rand.nextInt(2);
			if (e == 1) {
				if (mySpaceship.crewGetter(i) instanceof Gnome) {
					System.out.println("This member is immune!");
				} else {
					mySpaceship.getSick(i);
					PlagueAlertGUI plagueGUI = new PlagueAlertGUI(i, mySpaceship);
				}
			}
		}
	}
	
	/**
	 * Returns the current location of the spaceship
	 * @return location of the spaceship
	 */
	public int getSpaceshipLocation() {
		return spaceshipLocation;
	}
	
	/**
	 * Returns if a transporter piece was found on this planet. 
	 * @return true if a transporter was found on this planet otherwise false
	 */
	public boolean getPartFound() {
		return this.partFoundHere;
	}
	
	/**
	 * Should be called when a new piece of transporter is found.
	 * Checks if all parts are found.
	 */
	public void partFound() {
		this.partsAquired += 1;
		this.partFoundHere = true;
		System.out.println("parts aquired:");
		System.out.println(this.partsAquired);
		System.out.println("parts needed:");
		System.out.println(this.totalParts);
		if (this.partsAquired == this.totalParts) {
			gameOver();
		}
	}
	
	/**
	 * Changes the location of the spaceship.
	 */
	public void nextPlanet() {
		this.partFoundHere = false;
		this.spaceshipLocation += 1;
		System.out.println("New part can be found here.");
		astroidBelt();
	}
	
	/**
	 * Starts the game over screen.
	 */
	public void gameOver() {
		gameGUI.closeWindow();
		EndGameGUI endGame = new EndGameGUI(this, mySpaceship);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.launchOpeningScreen();
	}

}
