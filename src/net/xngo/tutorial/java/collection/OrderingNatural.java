package net.xngo.tutorial.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import net.xngo.tutorial.java.collection.Name;

public class OrderingNatural
{
  public static void main(String[] args)
  {
    ArrayList<Name> listOfNames = new ArrayList<Name>();
    
    listOfNames.add( new Name("Xuan", "Ngo") );
    listOfNames.add( new Name("John", "Smith") );
    listOfNames.add( new Name("Anna", "Kidman") );
    listOfNames.add( new Name("Jack", "Smith") );
    listOfNames.add( new Name("Anna", "Jones") );
        
    Collections.sort(listOfNames);
    display(listOfNames);

    System.out.println("=================================");
    Collections.sort(listOfNames, new LastNameComparator());
    display(listOfNames);

  }

  public static void display(ArrayList<Name> l)
  {
    for(Name name: l)
    {
      System.out.println(name);
    }
  }
}
