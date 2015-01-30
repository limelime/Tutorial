package net.xngo.tutorial.java.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream;
import java.util.Iterator;

public class InvalidFilenameCharacters
{

  public static void main(String[] args)
  {
    try
    {
      DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("."));
      for (Iterator<Path> iterator = paths.iterator(); iterator.hasNext();) 
      {
        Path path = iterator.next();
        String filename = path.getFileName().toString(); // The filename here is correct
        
        System.out.println(filename+": "+path.toFile().length());
      }
    }
    catch(IOException ex)
    {
      ex.printStackTrace();
    }
  }

}
