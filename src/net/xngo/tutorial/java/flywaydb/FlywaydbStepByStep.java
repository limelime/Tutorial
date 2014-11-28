package net.xngo.tutorial.java.flywaydb;

import java.io.File;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.MigrationInfoService;
import org.flywaydb.core.api.MigrationInfo;

/**
 * How to use Flywaydb programmatically: Breakdown step-by-step migrations.
 * Libraries needed: flyway-core-3.0.jar, sqlite-jdbc-3.7.2.jar
 * 
 * @author Xuan Ngo
 *
 */
public class FlywaydbStepByStep
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
    flyway.setInitOnMigrate(true);
    
    /**
     * Find which versions are not applied yet.
     */
    MigrationInfoService migrationInfoService = flyway.info();
    MigrationInfo[] migrationInfo = migrationInfoService.all();
    
    for(MigrationInfo mi: migrationInfo)
    {
      String version = mi.getVersion().toString();
      String state = mi.getState().isApplied()+"";
      System.out.println(String.format("Is target version %s applied? %s", version, state));
    }
    
    /**
     * Apply version you like.
     */
    MigrationVersion migrationVersion = MigrationVersion.fromVersion("1");
    flyway.setTarget(migrationVersion);
    flyway.migrate(); // Migrate up to version set in setTarget().
    
    migrationVersion = MigrationVersion.fromVersion("2");
    flyway.setTarget(migrationVersion);
    flyway.migrate(); // Migrate up to version set in setTarget().    
  }
}
