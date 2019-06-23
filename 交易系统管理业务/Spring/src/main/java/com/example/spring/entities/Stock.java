package com.example.spring.entities;

public class Stock {
	public String name;
	public int id;
	public double newPrice;
	public int newAmount;
	public double upLimit;
	public double downLimit;
	public boolean mode;

	public Stock(int id,String name, double newPrice, int newAmount, double upLimit, double downLimit, boolean mode) {
		this.id=id;
		this.name = name;
		this.newPrice = newPrice;
		this.newAmount = newAmount;
		this.upLimit = upLimit;
		this.downLimit = downLimit;
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "|Stock|" +
				" Name:" +
				name +
				" Latest Price:" +
				newPrice +
				" Latest Amount:" +
				newAmount +
				" Uplimit:" +
				upLimit +
				" Downlimit:" +
				downLimit +
				" mode:" +
				mode;
	}
}
