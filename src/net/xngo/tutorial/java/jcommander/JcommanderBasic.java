package net.xngo.tutorial.java.jcommander;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * Show how to use JCommander, a command line parser.
 * @author Xuan Ngo
 *
 */
public class JcommanderBasic
{
  /** Variables to hold option value **/
  @Parameter(names = {"-a", "--age"}, description = "Your age.")
  public int age;
  
  @Parameter(names = {"-f", "--firstname"}, description = "Your first name.")
  public String firstname;
  
  
  public static void main(String[] args)
  {
    JcommanderBasic options = new JcommanderBasic();
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
    
    if(options.firstname!=null)
    {// User has entered the firstname.
      System.out.println("Your first name is "+options.firstname);
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
