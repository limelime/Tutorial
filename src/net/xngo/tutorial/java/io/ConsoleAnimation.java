package net.xngo.tutorial.java.io;

/**
 * Simulate processing wheel in console with characters: / - \.
 * The idea is to use '\r' to return to the beginning of line and
 *  then print a new character.
 * Note: You can use the same idea with backspace character('\b')
 *      but from experience, '\r' works much better than '\b'.
 * @author Xuan Ngo
 *
 */
public class ConsoleAnimation
{

  public static void main(String[] args)
  {
    for(int i=0; i<10; i++)
    {
      System.out.print('\r');  sleep();
      System.out.print('/');  sleep();
      System.out.print('\r');  sleep();
      System.out.print('-');  sleep();
      System.out.print('\r');  sleep();
      System.out.print('\\');  sleep();
    }

  }

  public static void sleep()
  {
    int time = 50; // milliseconds.
    try
    {
      Thread.sleep(time);
    }
    catch(InterruptedException ex)
    {
      ex.printStackTrace();
    }
  }
}
