package net.xngo.tutorial.java.string;

/**
 * Show how to use regular expression in String.replaceAll().
 * @author Xuan Ngo
 *
 */
public class ReplaceAllRegex
{

  public static void main(String[] args) 
  {
    String s = "";
 
    /*
     * Remove substring that ends with ,???$
     * Show how to escape and use $.
     */
    s = "53 001,88 $";
    s = s.replaceAll(",...\\$$", "\\$");
    System.out.println(s); // Output: 53 001$
 
    /*
     * Replace a substring regardless of its characters' case(Case Insensitive).
     */
    s = "CaSE Insensitive";
    s = s.replaceAll("(?i)case", "Case");
    System.out.println(s); // Output: Case Insensitive
 
    /*
     * Show how to use backreferences, reuse the matched pattern.
     */
    s = "High Medium Low";
    s = s.replaceAll("(High) (Medium) (Low)", "$3 $2 $1");
    System.out.println(s); // Output: Low Medium High
    
    /*
     * Replace all adjacent wildcard(*) with 1 wildcard(*).
     */
    s = "wild***card";
    s = s.replaceAll("[\\*\\*]+", "*");
    System.out.println(s); // Output: wild*card
    
    
  }

  
  
}
