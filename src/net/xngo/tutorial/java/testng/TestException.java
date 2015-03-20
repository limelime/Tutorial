package net.xngo.tutorial.java.testng;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 * Test an exception with TestNG.
 * @author Xuan Ngo
 *
 */
public class TestException
{
  @Test(description="Test catching exception", 
        expectedExceptions={RuntimeException.class}, expectedExceptionsMessageRegExp = "blabla")
  public void testException()
  {
    TestException testEx = new TestException();
    try
    {
      testEx.throwAnException();
      assertTrue(false, "This line should never be run."
                      + " It should throw an exception before this."); // It is a safety net.
    }
    finally // Don't catch(){}. Otherwise TestNG will not catch it. Just do finally{}.
    {
      // Clean up code here.
    }
  }
  
  // Simulation of doing some work and throw an exception.
  public void throwAnException()
  {
    // Doing something and throw an exception.
    throw new RuntimeException("blabla");
  }

}
