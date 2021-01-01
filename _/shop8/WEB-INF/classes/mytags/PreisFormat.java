package mytags;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.*;
import java.util.*;

public class PreisFormat extends javax.servlet.jsp.tagext.TagSupport
{
   protected PageContext pageContext;
   private double preis;

   public void setPreis(double preis) throws JspException
   { this.preis = preis;  }
      
   public void setPageContext(PageContext pageContext)
   { this.pageContext = pageContext;  }
   
   public int doStartTag() throws JspException
   {
      DecimalFormat df =
      (DecimalFormat)DecimalFormat.getInstance(Locale.GERMAN);
      df.applyPattern( "EUR #,###,##0,00" );
      String s = df.format( preis );            
      try {  pageContext.getOut().write(s);
      }catch(java.io.IOException ex)
      { throw new JspException(ex.getMessage());   }
      return EVAL_BODY_INCLUDE;
   }
}
