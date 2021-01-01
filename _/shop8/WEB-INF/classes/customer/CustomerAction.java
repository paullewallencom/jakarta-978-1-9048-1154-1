package customer;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import tools.*;

public final class CustomerAction extends Action
{
   java.util.logging.Logger logger = LoggerInitiator.getLogger();

   public CustomerAction()
   {
      logger.info("CustomerAction.java");
   }

    public ActionForward execute(ActionMapping mapping,
	    ActionForm form, HttpServletRequest req,
		 HttpServletResponse res) throws Exception
    {
      CustomerForm kf = (CustomerForm)form;
      Customer k = kf.getCustomer();
      javax.sql.DataSource dataSource;
      java.sql.Connection myConnection = null;;
      logger.info("Requesting Connection");
      dataSource = getDataSource(req);
      logger.info("Have connection:" + dataSource);
      myConnection = dataSource.getConnection();

      String sql = "INSERT INTO Customer (firstname, name, street, housenumber, "
         + "zipcode, city, password, mail) "
         + "VALUES('" + k.getFirstname() + "', '" + k.getName()
         + "', '" + k.getStreet() + "', " + k.getHousenumber()
         + ", " + k.getZipcode() + ", " + "'" + k.getCity() + "', '"
         + k.getPassword() + "', '" + k.getMail() + "')";
       logger.info(sql);
      myConnection.createStatement().execute(sql);
      return mapping.findForward("customerCreated");
    }


}