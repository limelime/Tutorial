package net.xngo.tutorial.java.io;

/**
 * Simulate processing wheel in console with characters.
 * The idea is to use '\b' to remove the last character and
 *  then print a new 1.
 * @author Xuan Ngo
 *
 */
public class ConsoleAnimation
{

  public static void main(String[] args)
  {
    for(int i=0; i<10; i++)
    {
      System.out.print('/');  sleep();
      System.out.print('\b'); sleep();
      System.out.print('-');  sleep();
      System.out.print('\b'); sleep();
      System.out.print('\\'); sleep();
      System.out.print('\b'); sleep();
    }
    
    // Note: '\b' will not work in Eclipse console. There is bug.
    //      https://bugs.eclipse.org/bugs/show_bug.cgi?id=76936
    
    // Note: '\b' will not work over newline.
    //      http://stackoverflow.com/questions/3593339/why-doesnt-sys-stdout-write-b-backspace-against-newlines
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
