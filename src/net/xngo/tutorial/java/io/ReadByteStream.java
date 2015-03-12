package net.xngo.tutorial.java.io;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Description: Read stream data into buffer for the beginning, the middle and the end of the stream.
 * 
 * Reference: http://www.tutorialspoint.com/java/io/inputstream_read_byte.htm
 *
 */
public class ReadByteStream
{


  public static void main(String[] args)
  {
    int buffer_size = 5;

    byte[] buffer = new byte[buffer_size];
    try
    {
      InputStream inputStream = new FileInputStream("./filename.txt"); // File contains letters from a to z.
      
      // Total length of stream.
      int total_length = inputStream.available();

      //*** Beginning buffer
      System.out.print("Beginning: ");
      inputStream.read(buffer);       // read stream data into buffer
      displayBuffer(buffer);

      //*** Middle buffer
      int skip_n_to_middle = (total_length / 2) - (buffer_size / 2) - buffer_size;
      System.out.println("Skip the next " + skip_n_to_middle + " bytes.");
      inputStream.skip(skip_n_to_middle);
      inputStream.read(buffer);
      displayBuffer(buffer);

      //*** Last buffer
      int skip_n_to_last = total_length - buffer_size - skip_n_to_middle - buffer_size - buffer_size;
      System.out.println("Skip the next " + skip_n_to_middle + " bytes.");
      inputStream.skip(skip_n_to_last);
      inputStream.read(buffer);
      displayBuffer(buffer);

      inputStream.close();

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

  }
  
  // Helper to display buffer.
  static public void displayBuffer(byte[] buffer)
  {
    char c;
    // For each byte in the buffer
    for (byte b : buffer)
    {
      // Convert byte to character
      c = (char) b;

      // Print character
      System.out.print(c);
    }
    System.out.println();
  }

}
