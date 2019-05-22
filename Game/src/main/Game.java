package main;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * This class implements the events in the game.
 *
 */
public class Game {
	private int spaceshipLocation;
	private int gameLength;
	private int turnNum;
	private int totalParts;
	private int partsAquired;
	private boolean partFoundHere;
	private Spaceship mySpaceship;
	private Crew member;
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
	
	/**
	 * Starts the game.
	 */
	public void startGame() {
		System.out.println("How many days would you like the game to last?");
		gameLength = input.nextInt();
		input.nextLine();
		double doubleLength = gameLength;
		double doubleParts = (doubleLength / 3) * 2;
		totalParts = (int) doubleParts;
		mySpaceship = new Spaceship();
		System.out.println("Enter the number of crew(2-4)");
		int numberOfCrew = input.nextInt();
		while(numberOfCrew != 0) {
			pickCrew();
			numberOfCrew -= 1;
		}
		System.out.println("Enter a name for your spaceship");
		String spaceshipName = input.nextLine();
		System.out.println(spaceshipName);
		mySpaceship.setName(spaceshipName);
		partsAquired = 0;
		turnNum = 1;
		spaceshipLocation = 1;
		partFoundHere = false;
	}
	
	/**
	 * Lets the user pick the crew member they want.
	 */
	public void pickCrew() {
		System.out.println("Enter the type of crew member you want");
		System.out.println("1 = Tank - has more health");
		System.out.println("2 = Consumer - Benefits more from items");
		System.out.println("3 = Repair Expert - better at repairing the ship");
		System.out.println("4 = Search Expert - better at searching");
		System.out.println("5 = Gnome - immune to plague?");
		System.out.println("6 = Insomniac - Needs less sleep");

		int crewNum = input.nextInt();
		input.nextLine();
		System.out.println("Enter the crew member's name");
		String name = input.nextLine();
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
			System.out.println("Invalid choice, pick again");
			pickCrew();
			return;
		}
		mySpaceship.addCrew(member);
		member.setActions();
	}
	/**
	 * Lets the user pick an action to take in the game
	 */
	public void selectAction() {
		System.out.println("Select the action you want to take:");
		System.out.println("1 = View crew");
		System.out.println("2 = Set crew action");
		System.out.println("3 = View inventory");
		System.out.println("4 = View ship status");
		System.out.println("5 = Visit space outpost");
		System.out.println("6 = Go to next day");
		
		int choice = input.nextInt();
		if(choice == 1) {
			//view crew
		} else if(choice == 2) {
			// set crew action
		} else if(choice == 3) {
			// view inventory
		} else if(choice == 4) {
			//view ship status
		} else if(choice == 5) {
			//visit space outpost
		} else if(choice == 6) {
			nextTurn();
		} else {
			System.out.println("Invalid choice, pick again");
			selectAction();
		}
		
	}
	/**
	 * Sick crew members will take damage and action count will be reset for all remaining crew members.
	 */
	public void nextTurn() {
		mySpaceship.sicknessCheck();
		mySpaceship.crewActionReset();
		if (turnNum == gameLength) {
			gameOver();
		} else {
			turnNum += 1;
		}
	}
	
	/**
	 * Pick an event by random, the player should be alerted of the event.
	 */
	public void eventPicker() {
		int e = rand.nextInt(10);
		if (e == 1 || e == 2) {
			astroidBelt();
		} else if (e == 3) {
			pirates();
		} else if (e == 4) {
			plague();
		}
		return;
	}
	
	/**
	 * Decreases shield level of the ship. The ship also takes damage.
	 */
	public void astroidBelt() { 
		int damage = 700;
		System.out.println("Going though an astoid belt");
		int currentShield = mySpaceship.getShield();
		damage = (damage / currentShield * 5);
		mySpaceship.setHealth(mySpaceship.getHealth() - damage);
		if (mySpaceship.getHealth() > 0) {
			gameOver();
		}
		mySpaceship.setShield(mySpaceship.getShield() - 30);
	}
	
	/**
	 * Removes random item.
	 */
	public void pirates() {
		System.out.println("pirate invasion");
		int i = rand.nextInt(this.mySpaceship.lenInventory());
		this.mySpaceship.removeItem(this.mySpaceship.inventoryGetter(i));
		return;
	}
	
	/**
	 * Makes one or more crew members sick, sick crew members lose health everyday until cured with medicine.
	 */
	public void plague() {
		System.out.println("space plague");
		int sickPeople = rand.nextInt(mySpaceship.crewLen());
		for (int i = sickPeople; i > 0; i--) {
			int sickPerson = rand.nextInt(mySpaceship.crewLen());
			mySpaceship.getSick(sickPerson);
		}
	}
	
	/**
	 * Returns the current location of the spaceship
	 * 
	 */
	public int getSpaceshipLocation() {
		return spaceshipLocation;
	}
	
	/**
	 * Returns if a transporter piece was found on this planet. 
	 * @return
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
		if (partsAquired == totalParts) {
			gameOver();
		}
	}
	
	/**
	 * Changes the location of the spaceship.
	 */
	public void nextPlanet() {
		this.partFoundHere = false;
		this.spaceshipLocation += 1;
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();
		System.out.println(game.mySpaceship.getCrew());
	}

}
