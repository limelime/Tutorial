package net.xngo.tutorial.java.io;

public class ConsoleTest
{

  public static Console console = new Console();
  public static void main(String[] args)
  {
    console.printProgress("abc");
    console.printProgress("abcd");
    console.printProgress("ab");
    console.printProgress("b");
    console.printProgress("909");
    System.out.println("lines");
    console.printProgress("b");
  }

}
