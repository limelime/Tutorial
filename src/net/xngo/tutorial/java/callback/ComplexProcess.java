package net.xngo.tutorial.java.callback;

/**
 * Callback allows you to execute special codes in another process.
 * Reference: http://cleancodedevelopment-qualityseal.blogspot.ca/2012/10/understanding-callbacks-with-java.html
 * @author Xuan Ngo
 *
 */


/**
 * Definition of your callback/hook.
 */
interface CallBack 
{
  public void beforeDoingSomething();
  public void afterDoingSomething();
}

/**
 * Your own implementation of the callback.
 */
class CallBackImpl implements CallBack 
{
  public void beforeDoingSomething()
  {
    System.out.println("\t Before doing something.");
  }
  public void afterDoingSomething()
  {
    System.out.println("\t After doing something.");
  }
}

/**
 * Your class that allows callback.
 * It is in this class that define what to do 
 * with the callback.
 *
 */
public class ComplexProcess
{
  CallBack callback = null;
  public void setCallBack(CallBack callback)
  {
    this.callback = callback;
  }
  
  private void doSomething()
  {
    System.out.println("\t Doing something.");
  }
  
  public void run()
  {
    /**
     * If callback is NOT set, then run the default process.
     * Otherwise, allow the callback to modify the default process.
     */
    if(this.callback==null)
    {
      this.doSomething();
    }
    else
    {
      this.callback.beforeDoingSomething();
      this.doSomething();
      this.callback.afterDoingSomething();
    }
  }

  
  /**
   * Here is how you call your class.
   */
  public static void main(String[] args)
  {
    // Default run.
    System.out.println("Default run:");
    ComplexProcess defaultComplexProcess = new ComplexProcess();
    defaultComplexProcess.run();
    
    // Run with modification.
    System.out.println();
    System.out.println("Run with modification:");
    ComplexProcess complexProcessModified = new ComplexProcess();
    complexProcessModified.setCallBack(new CallBackImpl());
    complexProcessModified.run();
    
  }

}
