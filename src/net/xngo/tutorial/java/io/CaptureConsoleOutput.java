package net.xngo.tutorial.java.io;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Show how to capture standard output.
 * @author Xuan Ngo
 *
 */
public class CaptureConsoleOutput
{
  
  public static void main(String[] args)
  {
    // Get the original standard out before changing it.
    final PrintStream originalStdOut = System.out;
    
    ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    
    // Redirect all console outputs to consoleContent stream.
    System.setOut(new PrintStream(consoleContent));

    // Output to console.
    System.out.println("hello");
    
    // Reset the console back to the default state.
    System.setOut(originalStdOut);
        
    // Display what have been captured from the console.
    System.out.println("The output: " +consoleContent.toString());
    
  }

}
