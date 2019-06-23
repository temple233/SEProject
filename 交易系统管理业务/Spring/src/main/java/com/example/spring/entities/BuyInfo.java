package com.example.spring.entities;

import java.sql.Date;

public class BuyInfo {
	public double price;
	public double amount;
	public Date enterTime;

	public BuyInfo(double price, double amount, Date enterTime) {
		this.price = price;
		this.amount = amount;
		this.enterTime = enterTime;
	}

	@Override
	public String toString() {
		return "|Buy Instruction|" +
				" Price:" +
				price +
				" Amount:" +
				amount +
				" Enter time:" +
				enterTime;
	}
}