package net.xngo.tutorial.java.io;

import net.xngo.utils.java.math.Hash;
import net.xngo.utils.java.io.FileUtils;
import net.xngo.utils.java.time.Chronometer;

import java.util.ArrayList;
import java.util.Set;
import java.io.File;

public class HashPerf
{
  public static void main(String[] args)
  {

    String method = args[0];
    
    ArrayList<File> paths = new ArrayList<File>();
    paths.add(new File(args[1]));
    
    Chronometer chrono = new Chronometer();
    chrono.start();
    Set<File> listOfFiles = FileUtils.listFiles(paths);
    chrono.stop("Gather files");
    
    boolean displaySummary = true;
    if(method.compareTo("original")==0)
    {
      for(File file: listOfFiles)
      {
        try
        {
          Hash.xxhash32(file);
        }
        catch(Exception ex){ System.out.println(ex.getMessage()); }
      }
      chrono.stop("Hashing "+method);
    }
    else if(method.compareTo("super")==0)
    {
      for(File file: listOfFiles)
      {
        try
        {        
          Hash.xxhash32SuperClass(file);
        }
        catch(Exception ex){ System.out.println(ex.getMessage()); }
      }
      chrono.stop("Hashing "+method);
    }
    else if(method.compareTo("buffer")==0)
    {
      for(File file: listOfFiles)
      {
        try
        {
          Hash.xxhash32Buffer(file);
        }
        catch(Exception ex){ System.out.println(ex.getMessage()); }
      }
      chrono.stop("Hashing "+method);
    }
    else
    {
      System.out.println("Wrong method!");
      displaySummary=false;
    }
    
    if(displaySummary)
      chrono.display(String.format("Runtime (%,d) %s", listOfFiles.size(), method));
  }
}
