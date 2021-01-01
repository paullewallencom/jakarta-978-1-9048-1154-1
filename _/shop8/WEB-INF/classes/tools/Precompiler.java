package tools;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
   Deletes the "work" directory of the Tomcat for a given context and
   precompiles all provided JSPs. Note that the JSPs have to be provided
   in the (hardcoded) configuration file. <br />
   <b>Suggested usage:</b>
   <pre>
      try
      {
         Precompiler pc = new Precompiler();
         File f = new File(pc.getProperty("workDir"));
         pc.delete(f);
         pc.precompile();
     } catch(Exception ex) { System.err.println("Error:" + ex);}
   </pre>

   Configuration file:
   <pre>
   server=http://127.0.0.1:8080/shop8/
   workDir=c:/tomcat/work/Standalone/localhost/shop8

   u1=index.jsp
   u2=view/Customer.jsp
   </pre>
   @version 1.0
   @author stephan@stephan-wiesner.de
*/
public class Precompiler
{
   Properties props = new Properties();
   java.util.logging.Logger logger = LoggerInitiator.getLogger();

   public Precompiler() throws IOException
   {
      logger.info("Precompiler()");
      DataInputStream in = new DataInputStream( new BufferedInputStream(
         new FileInputStream("resources/urls.properties")));
      props.load(in);
   }


   public String getProperty(String value)
   {  return props.getProperty(value);   }


   /**
      recursively deletes all files (NOT! the directories) in the given
      directory.
   */
   public void delete(File dir) throws IOException
   {
      logger.info("Precompiler.delete()");
      File[] files = dir.listFiles();
      logger.info("have " + files.length + " files");
      for(int i = 0; i < files.length; i++)
      {
         if (files[i].isDirectory())
         {
            delete(files[i]);
         }
         else
         {
            logger.info("Deleting:" + files[i].getAbsolutePath() + "="
            + files[i].delete());
         }
      }
   }



   /**
      Precompiles the provided JSPs. Call delete first, if you want ALL
      JSPs to be recompiled.
   */
   public void precompile() throws Exception
   {
      logger.info("Precompiler.precompile()");
      String server = props.getProperty("server");
      for(int i = 1; i < props.size() - 1; i++)
      {
         String jsp = server + props.getProperty("u" + i) + "?jsp_precompile";
         System.out.println("Loading:" + jsp);
         URL url = new URL(jsp);
         url.openConnection().getInputStream();
      }
   }


   public static void main(String args[])
   {
      try
      {
         Precompiler pc = new Precompiler();
         File f = new File(pc.getProperty("workDir"));
         pc.delete(f);
         pc.precompile();
     } catch(Exception ex) { System.err.println("Error:" + ex);}

   }
}