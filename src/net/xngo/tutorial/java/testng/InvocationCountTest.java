package net.xngo.tutorial.java.testng;

import org.testng.annotations.Test;

/**
 * Using invocationCount in TestNG.
 * @author Xuan Ngo
 *
 */
public class InvocationCountTest
{
  @Test(description="Run this method multiple times.", invocationCount=3)
  public void printTime()
  {
    System.out.println(System.currentTimeMillis());
    try
    {
      Thread.sleep(1000); // Pause for 1 second.
    }
    catch(InterruptedException ex)
    {
      ex.printStackTrace();
    }
  }
}
