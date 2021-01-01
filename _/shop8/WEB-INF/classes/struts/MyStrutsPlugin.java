package struts;

import tools.*;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;

public class MyStrutsPlugin 
   implements org.apache.struts.action.PlugIn
{
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   
   public MyStrutsPlugin()
   {
      logger.info("MyStrutsPlugin()");
   }
   
   
   public void destroy()
   {
      logger.info("MyStrutsPlugin.destroy()");
   }
   
   
   public void init(ActionServlet servlet,
      ModuleConfig config)
      throws javax.servlet.ServletException
   {
      logger.info("MyStrutsPlugin.init(" + servlet
      + ", " + config + ")");
   }
}