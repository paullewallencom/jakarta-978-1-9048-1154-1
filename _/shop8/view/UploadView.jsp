<%@page import="java.io.*"%>

<%
   String mimetype = (String)session.getAttribute("mime");
   if (mimetype == null) 

   { response.setContentType("application/generic"); }
   else { response.setContentType(mimetype); }
 
   /*

   response.setHeader("Content-Disposition","inline; " 
      + "filename=\"out.jpg\"");
  */
   byte[] bytes = (byte[])session.getAttribute("file");
   response.getOutputStream().write(bytes, 0, bytes.length);

   
%>   