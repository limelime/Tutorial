package net.xngo.tutorial.java.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example showing simple connection to SQLITE database.
 * Note: C:/temp/tmpSqlite.db has to be change according to your situation.
 * @author Xuan Ngo
 *
 */
public class SqliteConnection
{

  public static void main(String[] args)
  {
   
    // Where your database is or will be stored.
    String databaseURL = "jdbc:sqlite:/C:/temp/tmpSqlite.db";
    
    try
    {
      // Load the sqlite-JDBC driver using the current class loader
      Class.forName("org.sqlite.JDBC");
      
      // Create a database connection
      Connection  connection = DriverManager.getConnection(databaseURL);
      Statement   statement  = connection.createStatement();
      
      // Create a Person table.
      statement.executeUpdate("CREATE TABLE Person(first_name TEXT, last_name TEXT, age INT)");
      
      /**
       * If you have sqlite binary, you can run the following command to verify that Person table is created.
       *    >sqlite3.exe C:\temp\tmpSqlite.db ".schema"
       *        CREATE TABLE Person(first_name TEXT, last_name TEXT, age INT);
       */
      
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
