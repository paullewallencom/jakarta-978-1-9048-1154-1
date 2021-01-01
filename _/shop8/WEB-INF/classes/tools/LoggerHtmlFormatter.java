package tools;

import java.io.*;
import java.util.logging.*;
import java.util.*;
import java.text.*;

/**
   Formats the output of the default Logger from the JDk (since 1.4)
   for HTML.
   
   @author stephan@stephan-wiesner.de
   @version 0.6
*/
public class LoggerHtmlFormatter extends Formatter
{
   /**
     This method is called for every log records and does the formatting.
     @param rec The LogRecord to format
     @return The formatted String.
   */
   public String format(LogRecord rec)
   {
      try {
         StringBuffer buf = new StringBuffer(1024);
         buf.append(getTime(rec.getMillis()));
         buf.append(" " + rec.getSourceClassName() + "." 
            + rec.getSourceMethodName() + ": ");
         buf.append("<b>" + formatMessage(rec) + "</b>");
         buf.append("(" + rec.getLevel() + ")");
         buf.append('\n');
         return buf.toString();
      } catch(Exception ex) 
      { 
         System.err.println("Error:" + ex);
         return "";
      }
      
   }

   
    /**
      Returns the actual time in the given format.<br>
      Actually a just little helper method. <br>
      z.B.: "yyyy-MM-dd HH:mm:ss"
    */
    public String getTime(long time)
    {
      String format = "yyyy-MM-dd HH:mm:ssSS";
      Locale currentLocale = new Locale("DEU", "DEU");;
      java.util.Date today = new java.util.Date(time);
      DateFormat dateFormatter =
         DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
      SimpleDateFormat formatter;
      formatter = new SimpleDateFormat(format, currentLocale);
      return formatter.format(today);
    }          

   /**
      This method is called just after the handler using this
      formatter is created
      @param handler
      @return The frame of an HTML file header.
   */
   public String getHead(Handler handler)
   {
      return "<html><head><title>Logging: " 
       + getTime(System.currentTimeMillis()) + "</title></head><body><pre>\n";
   }


   /** This method is called just after the handler using this
      formatter is closed
      @param handler
      @return The frame of an HTML file footer.
   */
   public String getTail(Handler handler)
   {
      return "</pre></body></html>\n";
   }
}
