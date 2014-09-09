package net.xngo.tutorial.java.lang;

import java.util.Calendar;

/**
 * Add variable values in a string.
 * @author Xuan Ngo
 *
 */
public class ParameterizedString
{
  public static void main(String[] args)
  {
    int        i = 142343;
    long       l = 454374587;
    float      f = 2.99f;
    double     d = 987663.90432;
    char       c = 'x';
    String     s = "String";
    Calendar now = Calendar.getInstance();
 
    // Simple parameterized string.
    String pString = String.format("Parameterized string examples: \n"
              + "\t Integer = %d \n"
              + "\t Long    = %d \n"
              + "\t Float   = %f \n"
              + "\t Double  = %f \n"
              + "\t Char    = %c \n"
              + "\t String  = %s \n"
              + "\t Now     = %tF\n"
              , i, l, f, d, c, s, now);
    System.out.println(pString);
    
    // Showing different useful features.
    pString = String.format("Parameterized string examples: \n"
            + "\t Integer = %,d     \n" // Add thousand separator.
            + "\t Long    = %d      \n"
            + "\t Float   = %f      \n"
            + "\t Double  = %.2f    \n" // Show only 2 decimal points.
            + "\t Char    = %c      \n"
            + "\t String  = %s      \n"
            + "\t Now     = %tF     \n" // YYYY-MM-DD
            + "\t Argument= %2$d    \n" // Get the value of the 2nd input argument/parameter.
            , i, l, f, d, c, s, now);
    System.out.println(pString);
    
    // Showing different useful features.
    pString = String.format("Parameterized string examples: \n"
            + "\t Zero padding             = %09d  \n"  // Pad zeros so the length is 9 digits.
            + "\t Decimal Point / Thousand = %,.2f \n"  // Add decimal point and thousand separator.
            , i, d);
    System.out.println(pString);    

  }

}
