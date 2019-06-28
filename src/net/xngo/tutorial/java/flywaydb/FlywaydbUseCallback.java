package net.xngo.tutorial.java.flywaydb;


import java.io.File;
import java.sql.Connection;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.callback.FlywayCallback;
import org.flywaydb.core.api.MigrationInfo;

/**
 * How to use Flywaydb programmatically: Use FlywayCallback.
 * Libraries needed: flyway-core-3.0.jar, sqlite-jdbc-3.7.2.jar
 * 
 * @author Xuan Ngo
 *
 */
public class FlywaydbUseCallback implements FlywayCallback
{
  public static void main(String[] args)
  {
    // Delete myDatabaseFile.db so that all migrations are run.
    File dbFile = new File("C:/temp/Xuan/latest/test/myDatabaseFile.db");
    dbFile.delete();
    
    // Create Flywaydb instance.
    Flyway flyway = new Flyway();
    
    // Set your datasource.
    flyway.setDataSource("jdbc:sqlite:/"+dbFile.getAbsolutePath(), null, null);
    
    // Set the location of all your SQL files: V?__*.sql
    flyway.setLocations("filesystem:C:/temp/Xuan/latest/test/upgrade/sql/");
    
    // Force the creation of 'schema_version' table on existing database.
    flyway.setBaselineOnMigrate(true);
    
    // Add the callback.
    FlywaydbUseCallback fcallback = new FlywaydbUseCallback();
    flyway.setCallbacks(fcallback);
    
    // Migrate up to version set in setTarget().
    flyway.migrate();     
  }
  
  /**
   * Here are the available hooks.
   * 	More details at https://flywaydb.org/documentation/callbacks.html
   */
  public void afterBaseline(Connection connection)
  {}
  public void afterClean(Connection connection)
  {}
  public void afterEachMigrate(Connection connection, MigrationInfo info)
  {
    String version = info.getVersion().toString();
    System.out.println(String.format("afterEachMigrate: Version %s: Do something", version));
  }
  public void afterInfo(Connection connection)
  {}
  public void afterInit(Connection connection)
  {}
  public void afterMigrate(Connection connection)
  {}
  public void afterRepair(Connection connection)
  {}
  public void afterValidate(Connection connection)
  {}
  public void beforeBaseline(Connection connection)
  {}
  public void beforeClean(Connection connection)
  {}
  public void beforeEachMigrate(Connection connection, MigrationInfo info)
  {}
  public void beforeInfo(Connection connection)
  {}
  public void beforeInit(Connection connection)
  {}
  public void beforeMigrate(Connection connection)
  {}
  public void beforeRepair(Connection connection)
  {}
  public void beforeValidate(Connection connection)
  {}
}
