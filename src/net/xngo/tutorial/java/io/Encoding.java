package net.xngo.tutorial.java.io;

import java.io.UnsupportedEncodingException;

public class Encoding
{

  public static void main(String[] args)
  {
    try
    {
      System.out.println(new String("�".getBytes("UTF-8"), "ISO-8859-1"));
    }
    catch(UnsupportedEncodingException e)
    {
      e.printStackTrace();
    }

  }

}
