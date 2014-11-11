package net.xngo.tutorial.java.flywaydb;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.MigrationInfoService;
import org.flywaydb.core.api.MigrationInfo;

/**
 * How to use Flywaydb programmatically: Breakdown step-by-step migrations.
 * Need to add flyway-core-3.0.jar in your classpath.
 * @author Xuan Ngo
 *
 */
public class FlywaydbStepByStep
{
  public static void main(String[] args)
  {
    Flyway flyway = new Flyway();
    
    // Set your datasource.
    flyway.setDataSource("jdbc:sqlite:/C:/temp/Xuan/latest/test/FilesHub.db", null, null);
    
    // Set the location of all your SQL files: V?__*.sql
    flyway.setLocations("filesystem:C:\\temp\\Xuan\\latest\\test\\sql\\");
    
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
    MigrationVersion migrationVersion = MigrationVersion.fromVersion("2");
    flyway.setTarget(migrationVersion);
    flyway.migrate(); // Migrate up to version set in setTarget().
  }
}
