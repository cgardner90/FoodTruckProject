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

		myApp.addTruck();

		myApp.menu();
	}

	public void menu() {
		Scanner input = new Scanner(System.in);
		int response;
		do {
			System.out.println("Please select what you would like to do:");
			System.out.println(
					"1. List all Existing trucks.\n2. See Average Truck Rating.\n3.Display Highest Rated Truck.\n4. Quit the App.");
			response = input.nextInt();

			switch (response) {
			case 1:
				showTrucks();
				break;
			case 2:
				System.out.println("Average Rating: " + avgRating());
				break;
			case 3: highRate();
				break;
			case 4: // call method;
				break;
			default:
				// message or method;
				break;
			}
		} while (response != 4);
		input.close();
	}

	public void addTruck() {
		boolean allowed;
		boolean moveOn;
		do {
			System.out.println("Welcome to the Food Truck App!!");
			System.out.print("You will be prompted to enter up to five (5) Food Trucks.\n");
			System.out.print("When you are finished entering, simply type: \"QUIT\"\n");
			Scanner input = new Scanner(System.in);

			System.out.println("Enter the name of the Food Truck");
			String name = input.next();
			if (name.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.println("Enter the Type (example: \"Mexican\" or \"Burgers\"\n");
			String type = input.next();
			System.out.println("Enter a rating from 1-5");
			int rating = input.nextInt();
			allowed = (rating >= 1 && rating <= 5);
			if (!allowed) {
				do {
					System.out.print("Rating must be 1-5.\n");
					System.out.print("Enter a rating from 1-5");
					rating = input.nextInt();
					allowed = (rating >= 1 && rating <= 5);
				} while (!allowed);
			}
//		FoodTruck t = new FoodTruck(name, type, rating);
			fleet[numTrucks] = new FoodTruck(name, type, rating);
			numTrucks++;
			moveOn = numTrucks == 5;
		} while (!moveOn);

	}

	public void highRate() {
		int newHigh = 0;
		FoodTruck bestTruck = new FoodTruck();
		for (int i = 0; i < numTrucks; i++) {
			if (fleet[i].getRating() > newHigh) {
				newHigh = fleet[i].getRating();
				bestTruck = fleet[i];
			}
		}

		System.out.println("The highest rated truck is:\n "+ bestTruck.getName()+" \n" + "Rating: "+ bestTruck.getRating());
		
	
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
