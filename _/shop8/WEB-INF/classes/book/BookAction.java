package book;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.sql.*;
import tools.*;

public final class BookAction extends Action
{
   java.util.logging.Logger logger = LoggerInitiator.getLogger();

   public BookAction()
   { logger.info("BookAction.java");   }

   public ActionForward execute(ActionMapping mapping,
	    ActionForm form, HttpServletRequest req,
		 HttpServletResponse res) throws Exception
    {
      logger.info("Start execute(" + form + ") . . ." );
      BookForm bf = (BookForm)form;
      Book book = bf.getBook();
      javax.sql.DataSource dataSource;
      java.sql.Connection myConnection = null;
      try
      {
         logger.info("Requesting Connection");
         dataSource = getDataSource(req);
         logger.info("Have connection:" + dataSource);
         myConnection = dataSource.getConnection();

         String sql = "INSERT INTO book (isbn, titel, author, price) "
            + "VALUES(" + book.getIsbn() + ", '" +
            book.getTitel() + "', " + book.getAuthor() + ", "
            + book.getPrice() + ")";
         myConnection.createStatement().execute(sql);
      } catch (SQLException sqle)
      {
         logger.severe("Connection.process:" + sqle);
         if (sqle.getMessage().indexOf("Duplicate entry") > -1)
         { throw new SQLException("aaa");    }
         else throw new SQLException(sqle.getMessage());
      } finally
      {
         //enclose this in a finally block to make
         //sure the connection is closed
         try {  myConnection.close(); }
         catch (SQLException e)
         {logger.severe("Connection.close:" + e);  }
      }

      ActionErrors errors = new ActionErrors();
      errors.add(ActionErrors.GLOBAL_ERROR,
         new ActionError("error.detail", "UhOh, Fehler"));
       saveErrors(req, errors);

      return mapping.findForward("bookCreated");
   }

}

