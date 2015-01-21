package net.xngo.tutorial.java.lang;

/**
 * Show use of generic type.
 * http://docs.oracle.com/javase/tutorial/java/generics/types.html
 * http://www.oracle.com/technetwork/articles/java/juneau-generics-2255374.html
 * @author Xuan Ngo
 *
 */
public class GenericType
{
  /**
   * Generic version of the Box class.
   * @param <T> the type of the value being boxed
   */
  public class Box<T> 
  {
      // T stands for "Type"
      private T t;

      public void set(T t) { this.t = t; }
      public T get() { return t; }
  }  

  public static void main(String[] args)
  {
    GenericType gt = new GenericType();
    
    Box<Integer> integerBox = gt.new Box<Integer>();
    integerBox.set(new Integer(2));
    System.out.println(integerBox.get());
    
    Box<String> stringBox = gt.new Box<String>();
    stringBox.set(new String("String"));
    System.out.println(stringBox.get());    

  }

}
