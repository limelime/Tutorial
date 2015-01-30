package net.xngo.tutorial.java.jcommander;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * Show how to define default option value in JCommander.
 * @author Xuan Ngo
 *
 */
public class JCmdDefaultValue
{
  /** Variables to hold option value **/
  @Parameter(names = {"-a", "--age"}, description = "Age.")
  public int age=18;
  
  @Parameter(names = {"-y", "--year"}, description = "Year.")
  public int year=2015;
  
  
  public static void main(String[] args)
  {
    JCmdDefaultValue options = new JCmdDefaultValue();
    JCommander jc = new JCommander(options);  // Add your class holding the options.
    jc.parse(args);                           // Ask JCommander to parse the command line arguments.
    jc.setProgramName("ApplicationName");     // Set you application name.
    
    /** Validations and what to do with the options entered **/
    boolean isAnyOptionHit = false;
    
    if(options.age!=0)
    {// User has entered the age.
      System.out.println("Your age is "+options.age);
      isAnyOptionHit = true;
    }
    
    if(options.year!=0)
    {// User has entered the year.
      System.out.println("Your year is "+options.year);
      isAnyOptionHit = true;
    }
    
    // Display the usage information since user didn't enter any option.
    if(!isAnyOptionHit)
    {
      System.out.println("Please enter 1 of the following options.");
      jc.usage();
    }
      
      
  }

}
