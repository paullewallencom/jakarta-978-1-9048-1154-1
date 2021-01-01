package author;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import org.apache.struts.validator.*;

import tools.*;

/*
   <b>ActionForm</b>
*/
public class AuthorForm extends ValidatorForm
{
   private Author author;
   private java.util.logging.Logger logger = LoggerInitiator.getLogger();

   public void setAuthor(Author author)
   { this.author = author; }

   public Author getAuthor()
   { return this.author; }


   /**
   * Reset all properties to their default values.
   * @param mapping The mapping used to select this instance
   * @param request The servlet request we are processing
   */
   public void reset(ActionMapping mapping, HttpServletRequest request)
   { this.author = new Author();  }


   public ActionErrors validate(ActionMapping mapping,
   HttpServletRequest request)
   {
      ActionErrors errors = new ActionErrors();
      if ((author.getFirstname() == null) || (author.getFirstname().length() < 3))
      { errors.add("firstname", new ActionError("error.author.firstname")); }

      if ((author.getName() == null) || (author.getName().length() < 3))
      { errors.add("lastname", new ActionError("error.author.lastname")); }

      if (author.getId() <= 0)
      { errors.add("id", new ActionError("error.author.id")); }
      return errors;
   }

}

