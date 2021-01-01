package tools;


import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
   Singleton that initialises the Logger and returns the
   instance. 
   
   Uses the PropertiesSingleton to initialise a logfile and level.
   When a record is about to be 
   logged and the file size is greater than the limit, the file 
   is emptied before the record is logged.

   @author stephan@stephan-wiesner.de
   @version 0.6   
*/

public class LoggerInitiator
{
   private static Logger logger;
   private static PropertiesSingleton config;
   
   /**
      Private constructor, Singleton.   
   */
   private LoggerInitiator()
   {               }
   
   
   /**
      Initialises the logger.
   */
   private static void init()
   {
      config = PropertiesSingleton.getInstance();
      System.out.println(config.getProperty("log.level"));
      logger = Logger.getLogger("stephanwiesner");      
      logger.setLevel(Level.parse(config.getProperty("log.level")));
      try {
         FileHandler handler = new FileHandler(
         config.getProperty("log.file"), 
         Integer.parseInt(config.getProperty("log.size")), 1);
         handler.setFormatter(new LoggerHtmlFormatter());
         logger.addHandler(handler);
      } catch(Exception ex) 
      { 
         System.err.println("Error:" + ex);
         logger = null;
      }
   }


   /**
      Returns an initialised Java logger. 
      @since JDK1.4
   */
   public static Logger getLogger()
   {
      if (logger == null) { init();   }
      return logger;
   }

}
