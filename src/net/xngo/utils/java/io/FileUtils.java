package net.xngo.utils.java.io;

import java.text.DecimalFormat;

public class FileUtils
{
  /**
   * Return human readable file size. This function is limited to exabyte.
   * 
   * Source: http://stackoverflow.com/questions/3263892/format-file-size-as-mb-gb-etc
   * 
   * @param size
   * @return a human-readable display value (includes units - EB, PB, TB, GB, MB, KB or bytes).
   */
  public static String readableFileSize(long size) 
  {
    if(size <= 1) return size +" byte";
    final String[] units = new String[] { "bytes", "KB", "MB", "GB", "TB", "PB", "EB" };
    int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
    return new DecimalFormat("#,##0.##").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
  }
}
