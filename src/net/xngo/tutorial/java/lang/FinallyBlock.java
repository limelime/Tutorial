package net.xngo.tutorial.java.lang;

public class FinallyBlock
{

    public static void main(String[] args){

        finallyRanAfterException();
        finallyRanAfterReturn();

    }

    public static void finallyRanAfterException()
    {
        try{
            // Simulate exception is thrown.
            throw new RuntimeException("Throw an exception");
        }
        catch(Exception ex) { ex.printStackTrace(); }

        finally{
            System.out.println("Finally code block will run after an exception is thrown.");
        }    
    }

    public static int finallyRanAfterReturn()
    {
        try{
        	return 42;
        }
        
        finally{
            System.out.println("Finally code block will run after the 'return' statement.");
        }
    }

}
