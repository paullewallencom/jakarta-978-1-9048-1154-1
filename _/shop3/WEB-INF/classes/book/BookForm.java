package book;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import tools.*;

public class BookForm extends ActionForm
{
   private Book book = new Book();
   private java.util.logging.Logger logger =
      LoggerInitiator.getLogger();

   public void setTitle(String title)
   {
      logger.info("setTitle('" + title+ "')");
      book.setTitle(title);
   }
   public String getTitle()
   {
      logger.info("getTitle()");
      return book.getTitle();
   }

   public void setBook(Book book)
   { this.book = book; }
   public Book getBook()
   { return this.book; }

   public void reset(ActionMapping mapping,
      HttpServletRequest request)
   { this.book = new Book(); }

   public ActionErrors validate(ActionMapping mapping,
   HttpServletRequest request)
   {
      ActionErrors errors = new ActionErrors();
      if ((book.getTitle() == null)
         || (book.getTitle().length() < 3))
         { errors.add("Title",
         new ActionError("error.book.title")); }
      return errors;
   }
}

