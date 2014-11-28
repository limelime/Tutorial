package net.xngo.tutorial.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class AutoCommitOff
{
  public static Connection  connection  = null;
  public static Statement   statement    = null;
  
  public static void main(String[] args) throws SQLException
  {
    // Create the database.
    createDatabase();
    
    // Auto Commit off but queries are still processed.
    connection.setAutoCommit(false);
    statement.executeUpdate("INSERT INTO Person VALUES('Xuan', 'Ngo');");       // Add 1 row.
    statement.executeUpdate("INSERT INTO Person VALUES('John', 'Smith');");     // Add another row.
    ResultSet results = statement.executeQuery("SELECT COUNT(*) FROM Person;"); // Get the number of rows.
    System.out.println(String.format("Count = %d", results.getInt(1)));         // Display number of rows. Should be 2.
    results.close();  // Close ResultSet. Otherwise, rollack() will complain the database is locked.
    
    // Rollback
    connection.rollback();
    results = statement.executeQuery("SELECT COUNT(*) FROM Person;");
    System.out.println(String.format("Count = %d", results.getInt(1)));   // Should be 0 because everything is rollback.
  }

  public static void createDatabase()
  {
    // Where your database is or will be stored.
    String databaseURL = "jdbc:sqlite::memory:";
    
    try
    {
      // Load the sqlite-JDBC driver using the current class loader
      Class.forName("org.sqlite.JDBC");
      
      // Create a database connection
      connection = DriverManager.getConnection(databaseURL);
      statement  = connection.createStatement();
      
      // Create a Person table.
      statement.executeUpdate("CREATE TABLE Person(first_name TEXT, last_name TEXT)");
    }
    catch(SQLException e)
    {
      e.printStackTrace();
    }
    catch(ClassNotFoundException e)
    {
      e.printStackTrace();
    }    
  }
}
