package net.xngo.tutorial.java.lang;

public class GetClassName
{
    public static void main(String[] args)
    {
        // Output fully qualified class name: net.xngo.tutorial.lang.GetClassName
        System.out.println(new GetClassName().getClass().getName());
        System.out.println(GetClassName.class.getName());
        System.out.println(GetClassName.class.getCanonicalName());

        // Output class name: GetClassName
        System.out.println(new GetClassName().getClass().getSimpleName());
        System.out.println(GetClassName.class.getSimpleName()); 
    }
}
