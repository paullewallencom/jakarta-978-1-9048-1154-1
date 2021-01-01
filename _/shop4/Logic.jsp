<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.*, book.*"%>

<html:html locale="true">
<head><html:base/>
<title>Logic Tags</title>
</head>
<body>      
<%
BookCatalogue bk = new BookCatalogue();

Book b1 = new Book();
   b1.setTitel("Book 0");
   b1.setPrice(2100);
   bk.addBook(b1);
Book b2 = new Book();
   b2.setTitel("Book 2");
   b2.setPrice(1100);
   bk.addBook(b2);
Book b3 = new Book();
   b3.setTitel("Book 1");
   b3.setPrice(3100);
   bk.addBook(b3);
%>


Sorted by Price (Struts): <br />
<ol>
   <logic:iterate id="myBooks" 
      collection="<%= bk.getPriceSortedBooks() %>">
      <li>
         <bean:write name="myBooks" property="titel"/>=
         <bean:write name="myBooks" property="price"/>
      </li>
   </logic:iterate>
</ol>
<hr>

Sorted by Title (Struts): <br />
<ol>
   <logic:iterate id="myBooks" 
      collection="<%= bk.getBooks() %>">
      <li>
         <bean:write name="myBooks" property="titel"/>=
         <bean:write name="myBooks" property="price"/>
      </li>
   </logic:iterate>
</ol>

<%
   Iterator i = bk.getBooks();
   out.println("Sorted by Title (Java): <br /><ol>");
   while (i.hasNext())
   {
      Book b = (Book)i.next();      
      out.println("<li>" + b.getTitel() + "=" + b.getPrice() 
      + "</li>");
   }
   out.println("</ol>\n<hr>Sorted by price (Java): <br /><ol>");
      i = bk.getPriceSortierteBooks();
      while (i.hasNext())
      {
         Book b = (Book)i.next();      
         out.println("<li>" + b.getTitel() + "=" + b.getPrice() 
         + "</li>");
      }
   out.println("</ol>");
%>


</body></html:html>

