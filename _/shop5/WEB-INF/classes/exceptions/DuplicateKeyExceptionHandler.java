package exceptions;

import org.apache.struts.action.*;
import org.apache.struts.config.ExceptionConfig;

public class DuplicateKeyExceptionHandler extends 
   org.apache.struts.action.ExceptionHandler
{
   public ActionForward execute(java.lang.Exception ex,
      ExceptionConfig ec, ActionMapping mapping,
      ActionForm formInstance, javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException
   {
      System.err.println("ERROR:\n" + ec);
      request.getSession(true).setAttribute("error", ec.getKey());
      return mapping.findForward("duplicateKey");      
   }
}