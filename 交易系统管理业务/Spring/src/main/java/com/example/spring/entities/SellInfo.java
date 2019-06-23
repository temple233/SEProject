package com.example.spring.entities;

import java.sql.Date;

public class SellInfo {
	public double price;
	public double amount;
	public Date enterTime;

	public SellInfo(double price, double amount, Date enterTime) {
		this.price = price;
		this.amount = amount;
		this.enterTime = enterTime;
	}

	@Override
	public String toString() {
		return "|Sell Instruction|" +
				" Price:" +
				price +
				" Amount:" +
				amount +
				" Enter time:" +
				enterTime;
	}
}

