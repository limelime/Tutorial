package net.xngo.tutorial.java.lang;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * You're not allowed to add an entry to a collection while you're iterating over it.
 * Note that Iterator.remove is the only safe way to modify a collection during iteration.
 * http://stackoverflow.com/questions/9806421/concurrentmodificationexception-when-adding-inside-a-foreach-loop-in-arraylist#answer-9806449
 * @author Xuan Ngo
 *
 */
public class CollectionModification
{

  public static void main(String[] args)
  {
    // Create data.
    ArrayList<String> list = new ArrayList<String>();
    for(int i=0; i<5; i++)
    { 
      list.add(i+""); 
    }
    
    // Loop through list and add more items: Will NOT throw ConcurrentModificationException.
    Iterator<String> iter = list.iterator();
    boolean once1 = true;
    while(iter.hasNext())
    {
      String str = iter.next();
      System.out.println(str);
      
      if(once1)
      {
        list.add("Will NOT throw ConcurrentModificationException.");
        
        once1 = false;
      }
      
    }
    
    
    
    // Loop through list and add more items: Will throw ConcurrentModificationException.
    boolean once2 = true;
    for(String str: list)
    {
      System.out.println(str);
      if(once2)
      {
        list.add("Will throw ConcurrentModificationException.");
        once2 = false;
      }
    }
    

  }

}
