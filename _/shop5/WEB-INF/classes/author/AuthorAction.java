package author;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import tools.*;

/*
@author stephan@stephanwiesner.de
*/
public final class AuthorAction extends Action
{
   java.util.logging.Logger logger = LoggerInitiator.getLogger();

   public AuthorAction()
   {
      logger.info("AuthorAction.java");
   }



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
       AuthorForm af = (AuthorForm)form;
       Author author = af.getAuthor();
       author.create();
       author = new Author();
       form = null;
       return mapping.findForward("authorCreated");
    }
}
