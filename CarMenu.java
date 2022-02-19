package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarMenu {

	public static void main(String[] args) {
		//List<String> options = Arrays.asList("Display Cars");
		String connectionString = "jdbc:mysql://localhost:3306/cars";
		final String SELECT_CARS = "SELECT * FROM cars ";
		final String ADD_CAR = "INSERT INTO cars(make, model, color, year, price) VALUES( ?, ?, ?, ?, ?)";
		final String UPDATE_PRICE = "UPDATE cars SET price = ? WHERE id = ?";
		final String DELETE_CAR = "DELETE FROM cars WHERE id = ?";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Select an Option");
		System.out.println("1) Show cars");
		System.out.println("2) Add new car");
		System.out.println("3) Update car price");
		System.out.println("4) Delete car");
		int selection = sc.nextInt();
		if (selection == 1) {
		try {
			Connection conn = DriverManager.getConnection(connectionString, "root", "Password");
			System.out.println("Connected Successfully");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(SELECT_CARS);
			
			while (rs.next()) {
				System.out.println("Make :" + rs.getString(2) + " |Model :" + rs.getString(3) + " |Color :" + rs.getString(4) + " |Year :" + rs.getString(5) 
				+ " |Price:" + rs.getInt(6));
			}
			
		} catch (SQLException e) {
			System.out.println("Error Connecting");
			e.printStackTrace();
		}

	}
		else if( selection == 2) {
			
			try {
				Connection conn = DriverManager.getConnection(connectionString, "root", "Password");
				System.out.println("Connected Successfully");
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter make");
				String make = scanner.nextLine();
				System.out.println("Enter model");
				String model = scanner.nextLine();
				System.out.println("Enter color");
				String color = scanner.nextLine();
				System.out.println("Enter year");
				String year = scanner.nextLine();
				System.out.println("Enter price");
				int price = scanner.nextInt();
				
				
				PreparedStatement ps = conn.prepareStatement(ADD_CAR);
				ps.setString(1, make);
				ps.setString(2, model);
				ps.setString(3, color);
				ps.setString(4, year);
				ps.setInt(5, price);
				
				ps.executeUpdate();
				
			
				
			} catch (SQLException e) {
				System.out.println("Error Connecting");
				e.printStackTrace();
			}
			
		}
		else if(selection == 3) {
			try {
			Connection conn = DriverManager.getConnection(connectionString, "root", "Password");
			System.out.println("Connected Successfully");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Car id");
			int id = scanner.nextInt();
			System.out.println("Enter New Price");
			int price = scanner.nextInt();
			
			
			PreparedStatement ps = conn.prepareStatement(UPDATE_PRICE);
			ps.setInt(2, id);
			ps.setInt(1, price);
			
			ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Error Connecting");
			e.printStackTrace();
		}
}
		else if(selection == 4) {
			try {
			Connection conn = DriverManager.getConnection(connectionString, "root", "Password");
			System.out.println("Connected Successfully");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Car id");
			int id = scanner.nextInt();
			
			
			PreparedStatement ps = conn.prepareStatement(DELETE_CAR);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Error Connecting");
			e.printStackTrace();
		}
}
		else {
			System.out.println("Invalid selection");
		}
	
}
}

