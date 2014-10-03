package net.xngo.tutorial.java.lang;

/**
 * Show 'finally' code block will be called after exception is thrown or a 'return' statement.
 * The only time 'finally' won't be called is if you call System.exit() or if the JVM crashes first.
 * @author Xuan Ngo
 *
 */
public class FinallyBlock
{

  public static void main(String[] args)
  {
    
    finallyRanAfterException();
    finallyRanAfterReturn();

  }
  
  public static void finallyRanAfterException()
  {
    try
    {
      // Simulate exception is thrown.
      throw new RuntimeException("Throw an exception");
    }
    catch(Exception ex) { ex.printStackTrace(); }
    
    finally
    {
      System.out.println("Finally code block will run after an exception is thrown.");
    }    
  }
  
  public static int finallyRanAfterReturn()
  {
    try
    {
      return 42;
    }
    finally
    {
      System.out.println("Finally code block will run after the 'return' statement.");
    }
  }

}
