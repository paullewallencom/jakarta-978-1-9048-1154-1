import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.SQLException;
import javax.servlet.jsp.*;

public class StartServlet extends HttpServlet
{
   public void doGet(HttpServletRequest request, 
      HttpServletResponse response)
       throws ServletException, IOException
   {  processRequest(request, response);   }


   public void doPost(HttpServletRequest request, 
      HttpServletResponse response)
       throws ServletException, IOException
   {  processRequest(request, response);    }

   public void processRequest(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, 
      IOException
   {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        PageContext pageContext = null;
        try
        {
           JspFactory jspxFactory = 
              JspFactory.getDefaultFactory();
           pageContext = jspxFactory.getPageContext(this,
              request, response, "Fehler.jsp", true, 8192, true);
           // Einheitliche Kopfzeile
              RequestDispatcher rd = getServletContext().
                 getRequestDispatcher("/Kopf.jsp");
              rd.include(request, response);
           String option = request.getParameter("option");
           try
           {
               if (option == null)
               {
                   rd = getServletContext().getRequestDispatcher(
                       "/Main.jsp");
                   rd.include(request, response);
               }
               else
               {
                   rd = getServletContext().getRequestDispatcher(
                       "/" + option + ".jsp");
                   rd.include(request, response);
               }
           }catch(IOException ex)
           {
                System.err.println(ex);
                out.println("<h1>Ungültige Option</h1>");
           }
           // der einheitliche Fuss
              rd = getServletContext().getRequestDispatcher(
                 "/Fuss.jsp");
              rd.include(request, response);
        }catch (Exception ex)
        {
            // Fehler wird per JSP Mechanismus ausgegeben.
            if (pageContext != null) 
            { pageContext.handlePageException(ex); }
            else { out.println(ex.getMessage()); }
        }
    }
}
