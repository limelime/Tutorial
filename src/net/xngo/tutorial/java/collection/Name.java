package net.xngo.tutorial.java.collection;

import java.lang.Comparable;
/**
 * Show how to implement natural order of this class. See compareTo() method.
 * @author Xuan Ngo
 *
 */
public class Name implements Comparable<Name>
{
  private final String firstName, lastName;
  
  public Name(String firstName, String lastName)
  {
    if (firstName == null || lastName == null)
      throw new NullPointerException();
    this.firstName = firstName;
    this.lastName = lastName;    
  }
  
  public String getFirstName(){ return this.firstName; }
  public String getLastName(){ return this.lastName; }
  
  
  // The natural order of this class is to sort by first name followed by last name.
  public int compareTo(Name n)
  {
    int firstCompareResult = this.firstName.compareTo(n.firstName);
    if(firstCompareResult==0)
    {// First name is equal. Compare last name now.
      return this.lastName.compareTo(n.lastName);
    }
    else
      return firstCompareResult;
  }
  
  public String toString()
  {
    return this.firstName +" "+ this.lastName;
  }
}
