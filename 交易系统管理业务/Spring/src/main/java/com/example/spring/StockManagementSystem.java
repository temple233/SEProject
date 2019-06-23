package com.example.spring;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.example.spring.entities.*;
import com.example.spring.dbHandler;

public class StockManagementSystem {
	/*public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// Build a object mapper
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

//		// User test
//		User user = new User("GeZhichao", "123456");
//		StringWriter jsonUser = new StringWriter();
//		objectMapper.writeValue(jsonUser, user);
//		System.out.println(jsonUser);
//
//		System.out.println();
//
//		// Stock test
//		Stock stock = new Stock("茅台",  100.0, 100, 150.0, 50.0, true);
//		StringWriter jsonStock = new StringWriter();
//		objectMapper.writeValue(jsonStock, stock);
//		System.out.println(jsonStock);

		dbHandler dbH = new dbHandler();

		ArrayList<BuyInfo> buys = dbH.getBuyOrders("Apple");
		ArrayList<SellInfo> sells = dbH.getSellOrders("Apple");

		for (BuyInfo buy : buys) {
			System.out.println(buy);
		}

		System.out.println();

		for (SellInfo sell : sells) {
			System.out.println(sell);
		}

//		ArrayList<Stock> stocks = dbH.getStockData();
//		for (Stock stock : stocks) {
//			System.out.println(stock);
//		}
//
//		dbH.setMode(false, "Apple");
//		dbH.setUpLimit(20, "Apple");
//		dbH.setDownLimit(2, "Apple");
//
//		stocks = dbH.getStockData();
//		for (Stock stock : stocks) {
//			System.out.println(stock);
//		}

//		System.out.println(dbH.changePassword(new User("itemzheng", "123456")));
//		System.out.println(dbH.login(user));
	}*/
}
