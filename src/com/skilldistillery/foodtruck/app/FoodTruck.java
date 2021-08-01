package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

public class FoodTruck {
	
	String name;
	String type;
	int rating;
	final int FoodTruckId;
	
	{ 
	// set ID here using Math.random()?
		int n = 1;
		FoodTruckId = n;
		n++;
	}
	
	
	

	public FoodTruck(String n, String t, int r) {
		this.name = n;
		this.type = t;
		this.rating = r;
	
	}
	public FoodTruck() {
		super();
	}
	public void displayTruck() {
		System.out.println("Name: "+ this.name+" \nType: "+ this.type + "\nRating: "+ rating);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getFoodTruckId() {
		return FoodTruckId;
	}
	
		
		// Print out Truck Info to confirm.
//		FoodTruck[] fleet1 = new FoodTruck[maxTrucks];
	}
