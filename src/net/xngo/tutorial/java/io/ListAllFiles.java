package net.xngo.tutorial.java.io;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class ListAllFiles
{

  public static void main(String[] args)
  {
    File file = new File(args[0]);
//    System.out.println("Raw: "+file.getName());

    
//    file = fixPath(file);
    
    
    Collection<File> filesList = FileUtils.listFiles(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
    System.out.println("File: "+file.getAbsolutePath()+" = "+filesList.size());
    display(filesList);
    try
    {
      filesList = FileUtils.listFiles(file.getCanonicalFile(), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
      System.out.println("getCanonicalFile: "+file.getAbsolutePath()+" = "+filesList.size());
      display(filesList);
    }
    catch(IOException ex)
    {
      ex.printStackTrace();
    }
  }
  
  public static void display(Collection<File> filesList)
  {
    for(File f: filesList)
    {
      System.out.println("\t"+f.getAbsolutePath());
    }
  }
  
  public static File fixPath(File path)
  {
    if(path.getAbsolutePath().endsWith(":"))
      return new File(path.getAbsolutePath()+File.separator);
    else
      return path;
  }
}
