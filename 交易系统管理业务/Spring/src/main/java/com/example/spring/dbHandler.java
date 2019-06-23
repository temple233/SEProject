package com.example.spring;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.spring.entities.BuyInfo;
import com.example.spring.entities.SellInfo;
import com.example.spring.entities.Stock;
import com.example.spring.entities.User;

public class dbHandler {
	private String url = "jdbc:mysql://120.78.80.77:3306/se?serverTimezone=UTC";
	private String username = "se";
	private String password = "se";

	private Connection connection;

	public dbHandler() {
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connect success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Check whether this user is a valid one
	public boolean login(User user) {
		String name = user.name;
		String passwd = user.password;

		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from admin where name = '" + name + "' and password = '"+ passwd + "'";

			ResultSet rs = stmt.executeQuery(sql);
			return rs.isBeforeFirst();
		} catch (SQLException e) {
			return false;
		}
	}

	// Update password
	public boolean changePassword(User user) {
		if (user.password.equals(null))
			return false;
		else {
			String name = user.name;
			String passwd = user.password;

			try {
				Statement stmt = connection.createStatement();
				String sql = "update admin set password = '" + passwd + "' where name = '" + name + "'";

				stmt.executeUpdate(sql);
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
	}

	// Get stock data
	public ArrayList<Stock> getStockData() {
		ArrayList<Stock> stockData = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from stock_information";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
			    int id =rs.getInt(1);
				String name = rs.getString(2);
				double newPrice = rs.getDouble(3);
				int newAmount = rs.getInt(4);
				double upLimit = rs.getDouble(5);
				double downLimit = rs.getDouble(6);

				boolean mode;
				if (rs.getInt(7) == 1)
					mode = true;
				else
					mode = false;

				Stock stock = new Stock(id,name, newPrice, newAmount, upLimit, downLimit, mode);
				stockData.add(stock);
			}

			return stockData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Set uplimit
	public boolean setUpLimit(double newUpLimit, int stock_id) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "update stock_information set up_limit = " + newUpLimit + " where stock_id = " + stock_id;
//			System.out.println(sql);
			stmt.executeUpdate(sql);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Set downLimit
	public boolean setDownLimit(double newDownLimit, int stock_id) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "update stock_information set down_limit = " + newDownLimit + " where stock_id = " + stock_id;
//			System.out.println(sql);
			stmt.executeUpdate(sql);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Set mode
	public boolean setMode(boolean mode, int stock_id) {
		try {
			Statement stmt = connection.createStatement();

			int m = 0;
			if (mode)
				m = 1;

			String sql = "update stock_information set mode = " + m + " where stock_id = " + stock_id;
//			System.out.println(sql);
			stmt.executeUpdate(sql);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Get descending buy order
	// In table instructions, 0 for sell order, 1 for buy order
	public ArrayList<BuyInfo> getBuyOrders(int stock_id) {
		ArrayList<BuyInfo> buys = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			String sql = "select price, amount, time\r\n" +
					"from instructions\r\n" +
					"where mode = 1 and stock_id = " + stock_id + "\r\n" +
					"order by price DESC";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				double price = rs.getDouble(1);
				double amount = rs.getDouble(2);
				Date enterTime = rs.getDate(3);

				BuyInfo buy = new BuyInfo(price, amount, enterTime);
				buys.add(buy);
			}

			return buys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Get ascending sell order
	// In table instructions, 0 for sell order, 1 for buy order
	public ArrayList<SellInfo> getSellOrders(int stock_id) {
		ArrayList<SellInfo> sells = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			String sql = "select price, amount, time\r\n" +
					"from instructions\r\n" +
					"where mode = 0 and stock_id = " + stock_id + "\r\n" +
					"order by price ASC";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				double price = rs.getDouble(1);
				double amount = rs.getDouble(2);
				Date enterTime = rs.getDate(3);

				SellInfo sell = new SellInfo(price, amount, enterTime);
				sells.add(sell);
			}

			return sells;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}