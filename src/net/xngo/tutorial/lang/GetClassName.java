package net.xngo.tutorial.lang;

/**
 * Get class name.
 * @author Xuan Ngo
 *
 */
public class GetClassName
{

  public static void main(String[] args)
  {
    // Output fully qualified class name: net.xngo.tutorial.lang.GetClassName
    System.out.println(new GetClassName().getClass().getName());
    
    // Output class name: GetClassName
    System.out.println(new GetClassName().getClass().getSimpleName());
  }

}
