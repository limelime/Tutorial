package net.xngo.tutorial.java.io;

import java.io.FileInputStream;
import java.io.InputStream;
/**
 * Reference: http://www.tutorialspoint.com/java/io/inputstream_read_byte.htm
 *
 */
public class ReadByteStream
{
  public InputStream is = null;
  
  public ReadByteStream()
  {
    try
    {
      is = new FileInputStream("./filename.txt");
    }
    catch(Exception ex){}
  }
  
  public static void main(String[] args)
  {
    final int buffer_size = 5;

    byte[] buffer=new byte[buffer_size];
    
    ReadByteStream mstream = new ReadByteStream();
    
    try
    {

       
       int total_length = mstream.is.available();
       
       System.out.print("Beginning: ");
         mstream.displayBytes(buffer);
         
       int skip_n_to_middle = (total_length/2)-(buffer_size/2)-buffer_size;
       System.out.println("Skip the next "+skip_n_to_middle+" bytes.");
       mstream.is.skip(skip_n_to_middle);
       mstream.displayBytes(buffer);
       
       int skip_n_to_last = total_length-buffer_size-skip_n_to_middle-buffer_size-buffer_size;
       System.out.println("Skip the next "+skip_n_to_middle+" bytes.");
       mstream.is.skip(skip_n_to_last);
       mstream.displayBytes(buffer);       
       
       System.out.println("Characters printed:"+total_length+"="+skip_n_to_middle);
       
       mstream.is.skip(1);
       

       

       mstream.is.close();
       
    }
    catch(Exception e)
    {
       // if any I/O error occurs
       e.printStackTrace();
    }
    
  }
  
  public void displayBytes(byte[] buffer)
  {
    try
    {
      char c;
      // read stream data into buffer
      this.is.read(buffer);    
      // for each byte in the buffer
      for(byte b:buffer)
      {
         // convert byte to character
         c=(char)b;
         
         // prints character
         System.out.print(c);
      }
      System.out.println();
    }
    catch(Exception ex){}
  }

}
