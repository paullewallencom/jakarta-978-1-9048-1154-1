package mytags;

import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
    @version 0.1
    @author stephan@stephanwiesner.de
*/
public class CountryDate extends javax.servlet.jsp.tagext.TagSupport
{
   protected PageContext pageContext;
   
   
   public void setPageContext(PageContext pageContext)
   { this.pageContext = pageContext;  }
   
   public int doStartTag() throws JspException
   {
      Date today = new Date();      
      ServletRequest request = (ServletRequest)pageContext.getRequest();
      Locale user = request.getLocale();
      DateFormat dateFormatter = 
         DateFormat.getDateInstance(DateFormat.DEFAULT, user);
      String now = dateFormatter.format(today);
      
      try { pageContext.getOut().write(now);
      }catch(java.io.IOException ex)
      { throw new JspException(ex.getMessage()); }
      return EVAL_BODY_INCLUDE;
    }
}

