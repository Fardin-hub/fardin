package electricity.billing.system;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;
public class database {
	Connection connection;
	Statement statement;
	database() 
	{
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3305/Bill_System","root","Fardin@123");
	        statement=connection.createStatement();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String a[])
	{
		new database();
	}
}