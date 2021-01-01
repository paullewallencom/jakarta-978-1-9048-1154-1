package book;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import tools.*;

public class BookForm extends ActionForm
{
   private Book book = new Book();
   private java.util.logging.Logger logger =
      LoggerInitiator.getLogger();

   public void setTitel(String titel)
   {
      logger.info("setTitel('" + titel+ "')");
      book.setTitel(titel);
   }
   public String getTitel()
   {
      logger.info("getTitel()");
      return book.getTitel();
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
      if ((book.getTitel() == null)
         || (book.getTitel().length() < 3))
      { errors.add("title", new ActionError("error.book.title")); }
      if (book.getPrice() <= 0)
      { errors.add("price", new ActionError("error.book.price")); }
      if (book.getIsbn() <= 0)
      { errors.add("isbn", new ActionError("error.book.isbn")); }
      if (book.getAuthor() <= 0)
      { errors.add("author", new ActionError("error.book.author"));}
      return errors;
   }


}

