package net.xngo.tutorial.java.io;

import java.io.IOException;

public class CmdExecution
{

  public static void main(String[] args)
  {
    try
    {
      Process process = Runtime.getRuntime().exec("echo hello");
      //try { process.waitFor(); } catch(InterruptedException ex){ ex.printStackTrace(); } // Wait for the process to terminate.
      process.exitValue();
    }
    catch(IOException ex)
    {
      ex.printStackTrace();
    }

  }

}
