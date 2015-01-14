package net.xngo.tutorial.java.testng;

/**
 * AnnotationsExecutionOrder.java
 * Show execution order of commonly used annotations of TestNG
 * Author: Xuan Ngo
 */

/*
 // OUTPUT:
Ran Constructor.(Work Time = 477 ms)
Ran @BeforeTest method.(Work Time = 1976 ms)
Ran @BeforeClass method.(Work Time = 1651 ms)
Ran @BeforeMethod method.(Work Time = 671 ms)
Ran @Test method.(Work Time = 236 ms)
Ran @AfterMethod method.(Work Time = 1403 ms)
Ran @AfterClass method.(Work Time = 979 ms)
Ran @AfterTest method.(Work Time = 964 ms)
 */
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import java.util.Random;

public class AnnotationsExecutionOrder
{
  // Variables
  Random oRandom = new Random();
  final int MAX = 2000;

  // Constructor
  public AnnotationsExecutionOrder()
  {
    final int iRnd = oRandom.nextInt(MAX);
    this.pause(iRnd);
    System.out.println("Ran Constructor.(Work Time = " + iRnd + " ms)");
  }

  @BeforeClass
  public void BeforeClass()
  {
    final int iRnd = oRandom.nextInt(MAX);
    this.pause(iRnd);
    System.out.println("Ran @BeforeClass method.(Work Time = " + iRnd + " ms)");
  }

  @BeforeTest
  public void BeforeTest()
  {
    final int iRnd = oRandom.nextInt(MAX);
    this.pause(iRnd);
    System.out.println("Ran @BeforeTest method.(Work Time = " + iRnd + " ms)");
  }

  @BeforeMethod
  public void BeforeMethod()
  {
    final int iRnd = oRandom.nextInt(MAX);
    this.pause(iRnd);
    System.out.println("Ran @BeforeMethod method.(Work Time = " + iRnd + " ms)");
  }

  @Test
  public void Test()
  {
    final int iRnd = oRandom.nextInt(MAX);
    this.pause(iRnd);
    System.out.println("Ran @Test method.(Work Time = " + iRnd + " ms)");
  }

  @AfterMethod
  public void AfterMethod()
  {
    final int iRnd = oRandom.nextInt(MAX);
    this.pause(iRnd);
    System.out.println("Ran @AfterMethod method.(Work Time = " + iRnd + " ms)");
  }

  @AfterTest
  public void AfterTest()
  {
    final int iRnd = oRandom.nextInt(MAX);
    this.pause(iRnd);
    System.out.println("Ran @AfterTest method.(Work Time = " + iRnd + " ms)");
  }

  @AfterClass
  public void AfterClass()
  {
    final int iRnd = oRandom.nextInt(MAX);
    this.pause(iRnd);
    System.out.println("Ran @AfterClass method.(Work Time = " + iRnd + " ms)");
  }

  // Simulate some processing time by pausing.
  private void pause(long lPauseInMillisSec)
  {
    try
    {
      Thread.sleep(lPauseInMillisSec);
    }
    catch (Exception ex)
    {
      System.out.println("Can't sleep.");
    }

  }
}
