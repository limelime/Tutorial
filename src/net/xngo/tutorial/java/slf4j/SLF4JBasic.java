package net.xngo.tutorial.java.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simplest way to output "Hello world" using SLF4J.
 * You need slf4j-api-X.jar and a binding jar(e.g. slf4j-simple-X.jar, 
 *          slf4j-log4j12-X.jar, slf4j-jdk14-X.jar, etc)
 * Bindings: http://www.slf4j.org/faq.html#where_is_binding         
 * @author Xuan Ngo
 */
public class SLF4JBasic
{
  // Pros/Cons of static Logger: http://slf4j.org/faq.html#declared_static
  final static Logger logger = LoggerFactory.getLogger(SLF4JBasic.class);
  
  public static void main(String[] args)
  {
    for(int i=0; i<3;i++)
    {
      logger.info("Hello World");
    }
    System.out.println("Hello World from System.out.");
    
    
    /**
     * You don't configure your logging on SLF4j but through the logger
     * implementation used(i.e. binding used).
     * slf4j-simple-X.jar: http://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html
     *    It's either through system property
     *      -Dorg.slf4j.simpleLogger.defaultLogLevel=debug
     *        or
     *      -In simplelogger.properties file on your classpath(http://stackoverflow.com/a/5081386).     
     */
    
    /**
     * Log level: DEBUG > INFO > WARN > ERROR > FATAL
     * Logs that you will see will be the level defined and forward as listed as above.
     * For example, if you set the root level=WARN, then only WARN, ERROR and FATAL will be 
     *  logged.
     */
  }

}

/**************************************************************************
 *            Different logger configuration files
 **************************************************************************/
// Reference: http://saltnlight5.blogspot.ca/2013/08/how-to-configure-slf4j-with-different.html

/* simplelogger.properties:
      org.slf4j.simpleLogger.defaultLogLevel=debug
      org.slf4j.simpleLogger.showDateTime=true
      org.slf4j.simpleLogger.dateTimeFormat=yyyy-MM-dd HH:mm:ss.SSS
 */


/* log4j.properties:
  
 */

/* logback.xml: java -Dlogback.configurationFile=/path/to/config.xml
      <!--
        You need slf4j-api-X.jar, logback-classic-X.jar and logback-core-X.jar
        
        Pattern definition:
          http://logback.qos.ch/manual/layouts.html#conversionWord
      -->
      <configuration>
        <appender name="FILE" class="ch.qos.logback.core.FileAppender">
          <file>myApp.log</file>
          <encoder>
            <pattern>%date %level [%thread] %-5level %logger{10} [%file:%line] %msg%n</pattern>
          </encoder>
        </appender>
      
        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
          <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
          </encoder>
        </appender>
        
        <root level="debug">
          <appender-ref ref="STDOUT" />
          <appender-ref ref="FILE" />
        </root>
      </configuration> 
*/

