package net.xngo.tutorial.java.collection;

import java.util.Comparator;

/**
 * Different ordering than natural order of the object.
 * http://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
 * @author Xuan Ngo
 *
 */
public class LastNameComparator implements Comparator<Name>
{
  // Sort by last name and then follow by first name.
  public int compare(Name n1, Name n2)
  {
    int lastNameCompareResult = n1.getLastName().compareTo(n2.getLastName());
    if(lastNameCompareResult==0)
    {// Last name is equal. Compare first name now.
      return n1.getFirstName().compareTo(n2.getFirstName());
    }
    else
      return lastNameCompareResult;
  }
}
