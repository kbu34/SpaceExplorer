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
	private int spaceshipLocation;
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
	
	public int getTotalParts() {
		return this.totalParts;
	}
	
	public int getPartsAquired() {
		return this.partsAquired;
	}
	
	public int getTurnNum() {
		return this.turnNum;
	}
	
	public int getGameLen() {
		return this.gameLength;
	}
	
	public void launchOpeningScreen() {
		GameGUI gameGUI = new GameGUI(this);
	}
	
	public void closeOpeningScreen(GameGUI gameGUI) {
		gameGUI.closeWindow();
	}
	
	public void launchMainScreen() {
		gameGUI = new MainGameGUI(this, mySpaceship);
	}
	
	
	/**
	 * Lets the user pick the crew member they want.
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
			System.out.println("Select Crew member you would like to view");
			System.out.print(this.mySpaceship.getCrew());
			int crewMemberChoice = input.nextInt();
			System.out.print(this.mySpaceship.getCrewMember(crewMemberChoice - 1).viewStatus());
			
		} else if(choice == 2) {
			System.out.println("Select Crew member you would like to assign an action to");
			System.out.print(this.mySpaceship.getCrew());
			int crewMemberChoice = input.nextInt();
			Crew crewMember = this.mySpaceship.getCrewMember(crewMemberChoice - 1);			
			
		} else if(choice == 3) {
			System.out.print(this.mySpaceship.getInventory());
		} else if(choice == 4) {
			//this.mySpaceship.getStatus();
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
			if (member instanceof Insomniac) {
				member.setTiredness(member.getFatigue() + 20);
			} else {
				member.setTiredness(member.getFatigue() + 35);
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
			damage = (damage / currentShield * 5);
			mySpaceship.setHealth(mySpaceship.getHealth() - damage);
			if (mySpaceship.getHealth() > 0) {
				gameOver();
			} else {
				mySpaceship.setShield(mySpaceship.getShield() - 30);
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
	
	public void gameOver() {
		gameGUI.closeWindow();
		EndGameGUI endGame = new EndGameGUI(this, mySpaceship);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.launchOpeningScreen();
		//System.out.println(game.mySpaceship.getCrew());
	}

}
