package net.xngo.tutorial.java.io;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Description: Read data stream into buffer for the beginning, the middle and the end of the stream.
 * @author Xuan Ngo
 */
public class ReadByteStream
{

  public static void main(String[] args)
  {
    int buffer_size = 5;

    byte[] buffer = new byte[buffer_size];
    try
    {
      // Assuming filename.txt does exist. Tested with file containing letters from a to z.
      InputStream inputStream = new FileInputStream("./filename.txt");
      
      // Total length of stream.
      int total_length = inputStream.available();

      //*** Beginning buffer
      inputStream.read(buffer);       // read stream data into buffer
      displayBuffer("Beginning: ", buffer);

      //*** Middle buffer
      int skip_n_to_middle = (total_length / 2) - (buffer_size / 2) - buffer_size;
      System.out.println("\tWill skip the next " + skip_n_to_middle + " bytes.");
      inputStream.skip(skip_n_to_middle);
      inputStream.read(buffer);
      displayBuffer("Middle: ", buffer);

      //*** Last buffer
      int skip_n_to_last = total_length - buffer_size - skip_n_to_middle - buffer_size - buffer_size;
      System.out.println("\tWill skip the next " + skip_n_to_last + " bytes.");
      inputStream.skip(skip_n_to_last);
      inputStream.read(buffer);
      displayBuffer("Last: ", buffer);

      System.out.println("END"); // Use as a marker to see non-visible character(e.g. newline).
      
      inputStream.close();

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

  }
  
  // Helper to display buffer.
  static public void displayBuffer(String text, byte[] buffer)
  {
    // Text to print before the buffer.
    System.out.print(text);
    
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
