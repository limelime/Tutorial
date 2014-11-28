package net.xngo.tutorial.java.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;


public class Encoding
{

  public static void main(String[] args)
  {
    try
    {
      //String filename = new String("./filename\uFFFD.txt".getBytes("UTF-8"));
      String filename = new String("./filename\uFFFD.txt");
      FileWriter oFileWriter = new FileWriter(filename);
      BufferedWriter oBufferedWriter = new BufferedWriter(oFileWriter);
      oBufferedWriter.write("Java");
      oBufferedWriter.close();
      System.out.println("done:"+filename);
      
      byte[] bufferBlock = new byte[8192]; // 8192 bytes
      FileInputStream fileInputStream = new FileInputStream(new File(filename));
  
      int read;
      while ((read = fileInputStream.read(bufferBlock))!=-1) 
      {
        System.out.println(bufferBlock.toString());
      }
      
      fileInputStream.close();

    }
    catch(IOException ex)
    {
      System.out.println(ex.getMessage());
    }   

  }

}
