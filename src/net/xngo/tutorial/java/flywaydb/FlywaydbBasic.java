package net.xngo.tutorial.java.flywaydb;

import org.flywaydb.core.Flyway;

/**
 * How to use Flywaydb programmatically.
 * Libraries needed: flyway-core-3.0.jar, sqlite-jdbc-3.7.2.jar
 * 
 */
public class FlywaydbBasic
{
  public static void main(String[] args)
  {
    Flyway flyway = new Flyway();
    
    // Set your datasource.
    flyway.setDataSource("jdbc:sqlite:/C:/temp/test/latest/test/FilesHub.db", null, null);
    
    // Set the location of all your SQL files: V?__*.sql
    flyway.setLocations("filesystem:C:/temp/test/latest/test/sql/");
    
    // Force the creation of 'schema_version' table on existing database.
    flyway.setInitOnMigrate(true);
    
    // Execute all SQL files from C:\temp\test\latest\sql\ director with the following pattern: V?__*.sql
    flyway.migrate();
  }
}
