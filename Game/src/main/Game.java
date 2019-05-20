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
	private Spaceship mySpaceship;
    Scanner input = new Scanner(System.in);
	
	/**
	 * Starts the game.
	 */
	public void startGame() {
		System.out.println("Enter a name for your spaceship");
		String spaceshipName = input.nextLine();
		System.out.println(spaceshipName);
		mySpaceship = new Spaceship(spaceshipName);
		System.out.println("Enter the number of crew(2-4)");
		int numberOfCrew = input.nextInt();
		while(numberOfCrew != 0) {
			pickCrew();
			numberOfCrew -= 1;
		}
	}
	
	/**
	 * Reset action count of the crew, maybe decrease gameLength.
	 */
	public void nextTurn() {
		return;
	}
	
	/**
	 * Pick an event by random, the player should be alerted of the event.
	 */
	public void eventPicker() {
		Random rand = new Random();
		int e = rand.nextInt(10);
		if (e == 1) {
			astroidBelt();
		} else if (e == 2) {
			pirates();
		} else if (e == 3) {
			plague();
		}
		return;
	}
	
	/**
	 * Decreases shield level of the ship.
	 */
	public void astroidBelt() { 
		mySpaceship.setShield(mySpaceship.getShield() - 30);
		return;
	}
	
	/**
	 * Removes random item.
	 */
	public void pirates() {
		Random rand = new Random();
		int i = rand.nextInt(this.mySpaceship.lenInventory());
		this.mySpaceship.removeItem(this.mySpaceship.inventoryGetter(i));
		return;
	}
	
	/**
	 * Makes one or more crew members sick, sick crew members lose health everyday until cured with medicine.
	 */
	public void plague() {
		return;
	}
	
	/**
	 * Returns the current location of the spaceship
	 * 
	 */
	public int getSpaceshipLocation() {
		return spaceshipLocation;
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();
	}

}
