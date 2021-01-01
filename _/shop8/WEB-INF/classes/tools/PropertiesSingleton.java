package tools;

import java.io.*;
import java.util.*;

/**
 *  A <pattern>
 *
 *  Singleton</pattern> for the management of 'global' configuration data. <br
 *  />
 *  Most applications need only a single configuration file. They either reach a
 *  reference from object to object or reload it many times. Here it is loaded
 *  and created onl once, but can be accessed by many objects.
 *
 *@author     stephan@stephanwiesner.de
 *@created    1. Dezember 2002
 */
public class PropertiesSingleton
{
   /**  The singleton reference */
   private static PropertiesSingleton config;
   /**  The Properties object */
   private Properties props;
   /**  The path to the file containing the configuration */
   private static String configFile = "/resources/config.properties";


   /**
    *  Constructor is a Singleton. <br>
    *
    *
    *@param  configFile       The path to the file containing the configuration
    *@exception  IOException  Description of the Exception
    *@throws  IOException     if the file can not be loaded
    */
   private PropertiesSingleton(String configFile) throws IOException
   {
      this.configFile = configFile;
      props = new Properties();
      String myPath = this.getClass().getResource( configFile ).toString();
      props.load(this.getClass().getResourceAsStream( configFile ));      
   }


   /**
    *  Constructor is a Singleton. <br>
    *
    *
    *@param  baseClass The class is used to load the property file with
    *                  getClass().getResource()
    *@param  configFile The name of the file containing the configuration
    *@exception  IOException  If the file can not be loaded
    */
   private PropertiesSingleton(Class baseClass, String configFile)
          throws IOException
   {
      this.configFile = configFile;
      java.io.InputStream in = baseClass.getResourceAsStream(configFile);
      props = new Properties();
      props.load(in);
      System.out.println("Number:" + props.size());
   }



   /**
    *@return    The path to the file containing the configuration
    */
   public String getConfigFile()
   { return this.configFile;  }


   /**
    *@param  configFile    The path to the file containing the configuration
    *@return               Returns the Singleton instance <br>
    *
    *@throws  IOException  If a new instance is to be created and the
    *                      configuration file can not be loaded.
    */
   public static PropertiesSingleton getInstance(String configFile)
          throws IOException
   {      
      if (config == null) { config = new PropertiesSingleton(configFile);  }
      config.configFile = configFile;
      return config;
   }



   /**
    *@return Returns the Singleton instance
    *
    *@throws  IOException  If a an instance doesn't yet exist.
    */
   public static PropertiesSingleton getInstance() 
   {
      if (config == null)
      { 
         try {
         config = getInstance(configFile);
         }catch(IOException ex) { System.err.println("Error:" + ex);}
      }
      return config;
   }


   /**
    *@param  key  The key whose value is to be returned.
    *@return      Returns the asked for Property. Null if it doesn't exist.
    *
    */
   public String getProperty(String key)
   {
      return props.getProperty(key);
   }

}

