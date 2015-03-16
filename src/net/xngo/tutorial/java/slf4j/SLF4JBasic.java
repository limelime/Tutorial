package net.xngo.tutorial.java.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simplest way to output "Hello world" using SLF4J.
 * You need slf4j-api-X.jar and a binding jar(e.g. slf4j-simple-X.jar, 
 *          slf4j-log4j12-X.jar, slf4j-jdk14-X.jar, etc) 
 * Reference : http://www.slf4j.org/manual.html#hello_world 
 * @author Xuan Ngo
 */
public class SLF4JBasic
{
  // Pros/Cons: http://slf4j.org/faq.html#declared_static
  final static Logger logger = LoggerFactory.getLogger(SLF4JBasic.class);
  
  public static void main(String[] args)
  {
    logger.info("Hello World");
    System.out.println("Hello World from System.out.");
  }

}
