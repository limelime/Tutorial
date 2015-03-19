package net.xngo.tutorial.java.testng;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 * Catch an exception with Testng.
 * @author Xuan Ngo
 *
 */
public class CatchException
{
  @Test(description="Test catching exception", expectedExceptions={RuntimeException.class})
  public void catchException()
  {
    CatchException catchEx = new CatchException();
    try
    {
      catchEx.throwAnException();
      assertTrue(false, "This line should never be run."
                      + " It should throw an exception before this."); // It is a safety net.
    }
    finally
    {
      // Clean up code here.
    }
  }
  
  public void throwAnException()
  {
    throw new RuntimeException("blabla");
  }
  
  
}
