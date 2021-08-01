package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static FoodTruck[] fleet;
	private static int numTrucks = 0;
	public final static int maxTrucks = 5;

	{
		fleet = new FoodTruck[maxTrucks];
	}

	public static void main(String[] args) {

		FoodTruckApp myApp = new FoodTruckApp();

		myApp.greeting();
		System.out.println("\n\n");
		myApp.addTruck();

		myApp.menu();
	}

	public void greeting() {
		System.out.println("\t*** Welcome to the Food Truck App! ***\n");
		System.out.println(
				"  * This app allows you to enter up to 5 of your favorite\n   food trucks, along with descriptions and ratings!");
		System.out.println(
				"\n  * Once you build up a library of trucks, you'll be sent \n  to our App Menu to allow you to view your data.");
		System.out.print("\n\n**  First things first, you need to enter some trucks! Let's get started:");
	}

	public void addTruck() {
		boolean allowed;
		boolean moveOn;
		System.out.print("-- Please enter up to five (5) Food Trucks. Less than 5 is no problem.\n\n");
		System.out.print("-- Once you've added as many trucks as you'd like,\n simply type \"QUIT\" in the \"Enter a Name\" field \n and you'll be able to access the rest of the App.\n\n");
		do {
			Scanner input = new Scanner(System.in);

			System.out.println("* Enter the name of a Food Truck");
			String name = input.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.println("* Enter the Type (example: \"Mexican\" or \"Burgers\"");
			String type = input.next();
			System.out.println("\n");
			System.out.println("*  Finally, enter a rating from 1-5");
			int rating = input.nextInt();
			allowed = (rating >= 1 && rating <= 5);
			if (!allowed) {
				do {
					System.out.print("\tSorry, rating must be 1-5.\n");
					System.out.print(" * Enter a rating from 1-5");
					rating = input.nextInt();
					allowed = (rating >= 1 && rating <= 5);
				} while (!allowed);
			}
			fleet[numTrucks] = new FoodTruck(name, type, rating);
			numTrucks++;
			moveOn = numTrucks == 5;
		} while (!moveOn);

	}
	public void addMoreTrucks() {
		Scanner input = new Scanner(System.in);
		boolean moveOn;
		boolean allowed;
		int avail = maxTrucks-numTrucks;
		System.out.println("You can enter up to "+ avail+" more truck(s)");
		if(avail == 0 ) {
			menu();
		}
		System.out.println("Enter a Food Truck: ");
		String name = input.nextLine();
		if (name.equalsIgnoreCase("quit")) {
			menu();
		}
		
		System.out.println("* Enter the Type (example: \"Mexican\" or \"Burgers\"");
		String type = input.next();
		System.out.println("\n");
		System.out.println("*  Finally, enter a rating from 1-5");
		int rating = input.nextInt();
		allowed = (rating >= 1 && rating <= 5);
		if (!allowed) {
			do {
				System.out.print("\tSorry, rating must be 1-5.\n");
				System.out.print(" * Enter a rating from 1-5");
				rating = input.nextInt();
				allowed = (rating >= 1 && rating <= 5);
			} while (!allowed);
		}
		fleet[numTrucks] = new FoodTruck(name, type, rating);
		numTrucks++;
}
	
		



	
	public void menu() {
		Scanner input = new Scanner(System.in);
		int response;
		do {
			System.out.println("\nPlease select what you would like to do:");
			System.out.println(
					"\n\t1. List all Existing trucks.\n\t2. See Average Truck Rating.\n\t3.Display Highest Rated Truck.\n\t4. Add another truck. \n\t5. Quit the App.");
			response = input.nextInt();

			switch (response) {
			case 1:
				showTrucks();
				break;
			case 2:
				System.out.println("* The average rating of your trucks is " + avgRating());
				break;
			case 3:
				System.out.print("The highest rated Food Truck is: \n");
				highRate();
				break;
			case 4:
				addMoreTrucks();
				break;
			case 5:
				System.out.println("Thank you for using the Food Truck App today! \n We'll see you next time!");
				break;
			default:
				System.out.println("You've Entered an invalid response.");
				break;
			}
		} while (response != 5);
		input.close();
	}

	public void highRate() {
		int newHigh = 0;
		FoodTruck bestTruck = new FoodTruck();
		for (int i = 0; i < numTrucks; i++) {
			if (fleet[i].getRating() > newHigh) {
				bestTruck = fleet[i];
			}
		}

		bestTruck.displayTruck();

	}

	public void showTrucks() {
		for (int i = 0; i < numTrucks; i++) {
			fleet[i].displayTruck();
		}
	}

	public int avgRating() {
		int averageRating;
		int total = 0;
		int count = 0;
		for (int i = 0; i < numTrucks; i++) {
			total += fleet[i].getRating();
			count++;

		}
		averageRating = total / count;
		return averageRating;
	}

}
