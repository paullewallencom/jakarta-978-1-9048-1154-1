package customer;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import tools.*;

/*
@author stephan@stephanwiesner.de
*/
public final class FulfillOrderAction extends Action
{
   java.util.logging.Logger logger = LoggerInitiator.getLogger();

   public FulfillOrderAction()
   {  logger.info("FulfillOrderAction.java");   }



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
      logger.info("Emptying Basket");
      javax.sql.DataSource dataSource;
      java.sql.Connection myConnection = null;;
      dataSource = getDataSource(req);
      myConnection = dataSource.getConnection();
      HttpSession session = req.getSession(true);
      Customer k = (Customer)session.getAttribute("customer");
      String sql = "DELETE FROM Shoppingcart WHERE Customer=" + k.getId();
      myConnection.createStatement().execute(sql);
      return mapping.findForward("fulfillOrderSuccess");
    }
}
