package net.xngo.tutorial.java.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;


public class ReadFileNIO
{

  public static void main(String[] args)
  {
    Path path = Paths.get("./somefile.txt");
    try
    {
      BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset() );
      String line = null;
      while ( (line = reader.readLine()) != null )
      { /* … */ 
        
      }
    }
    catch(IOException ex)
    {
      ex.printStackTrace();
    }
  }

}
