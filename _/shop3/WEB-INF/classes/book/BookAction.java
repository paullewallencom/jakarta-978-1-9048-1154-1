package book;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import tools.*;

public final class BookAction extends Action
{
   java.util.logging.Logger logger = LoggerInitiator.getLogger();

   public BookAction()
   { logger.info("BookAction.java");  }

    public ActionForward execute(ActionMapping mapping,
      ActionForm form, HttpServletRequest req,
      HttpServletResponse res) throws Exception
   {
      logger.info("Start execute(" + form + ") . . ." );
      String title = req.getParameter("title");
      Book book = new Book();
      book.setTitle( title );
      req.setAttribute("BOOK", book);
      return mapping.findForward("bookCreated");
   }
}

