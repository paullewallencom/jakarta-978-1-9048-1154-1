package customer;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import tools.*;

/*
@author stephan@stephanwiesner.de
*/
public final class LoginAction extends Action
{
   java.util.logging.Logger logger = LoggerInitiator.getLogger();

   public LoginAction()
   {  logger.info("LoginAction.java");   }



   /**
   @param mapping The ActionMapping used to select this instance
   @param form The optional ActionForm bean for this request (if any)
   @param req The non-HTTP request we are processing
   @param res The non-HTTP response we are creating
   @return Return an ActionForward instance describing where and how
   control should be forwarded, or null if the response has already
   been completed.
   */
    public ActionForward execute(ActionMapping mapping,
	    ActionForm form, HttpServletRequest req,
		 HttpServletResponse res) throws Exception
    {
      DynaActionForm df = (DynaActionForm)form;
      String mail = (String)df.get("mail");
      String passwort = (String)df.get("password");
      logger.info("mail=" + mail + " / pass=" + passwort);
      Customer k = new Customer(mail, passwort);
      HttpSession session = req.getSession(true);
      session.setAttribute("customer", k);

      return mapping.findForward("loginSuccess");
    }
}
