package net.xngo.tutorial.java.apache.commons.io;

import java.io.File;
import java.nio.file.Files; // Require java version 1.7
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

/**
 * List all files and ignore symbolic links.
 * Provide your own implementation of *FileFilter.
 * @author root
 *
 */
public class CustomFileFilter
{

  public static void main(String[] args)
  {
    // Create a new file filter
    //  and override its accept-method to discard symbolic link.
    TrueFileFilter trueFileFilterNoSymbolicLink = new TrueFileFilter()
      {
          @Override
          public boolean accept(File file)
          {// Return false if it is symbolic link.
            if(Files.isSymbolicLink(file.toPath()))
              return false;
            else
              return true;
          }
        
      };              
    
    File file = new File("/some-path-containing-symbolic-links/");
    Collection<File> filesList = FileUtils.listFiles(file, trueFileFilterNoSymbolicLink, trueFileFilterNoSymbolicLink);
    
    for(File f: filesList)
    {
      System.out.println(f.getAbsolutePath());
    }

  }

}
