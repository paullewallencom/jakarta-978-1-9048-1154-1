package customer;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import org.apache.struts.validator.*;

import tools.*;

public class CustomerForm extends ActionForm
{
   private Customer customer = null;

   public void setCustomer(Customer customer)
   { this.customer = customer; }

   public Customer getCustomer()
   { return this.customer; }


   /**
   * Reset all properties to their default values.
   * @param mapping The mapping used to select this instance
   * @param request The servlet request we are processing
   */
   public void reset(ActionMapping mapping, HttpServletRequest request)
   { this.customer = new Customer();  }


   public ActionErrors validate(ActionMapping mapping,
   HttpServletRequest request)
   {
      ActionErrors errors = new ActionErrors();
      if ((customer.getFirstname() == null) || (customer.getFirstname().length() < 3))
      { errors.add("firstname", new ActionError("error.author.firstname")); }

      if ((customer.getName() == null) || (customer.getName().length() < 3))
      { errors.add("lastname", new ActionError("error.author.lastname")); }

      if ((customer.getPassword() == null) || (customer.getPassword().length() < 5))
      { errors.add("password", new ActionError("error.customer.password")); }

      if ((customer.getMail() == null) || (customer.getMail().length() < 7)
         || (customer.getMail().indexOf("@") < 0) )
      { errors.add("mail", new ActionError("error.customer.mail")); }
      return errors;
   }
}