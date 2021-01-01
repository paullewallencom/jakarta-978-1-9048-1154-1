<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://www.stephanwiesner.de/strutsbuch" prefix="sw" %>

<%@page import="tools.*, book.*, java.util.*"%>
<h2 class="title"><bean:message key="bookcatalogue.title"/></h2>
   
<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("BookCatalogueView.jsp");
   BookCatalogue bk = new BookCatalogue();
%>
 
<ol>
<logic:iterate id="myBooks" collection="<%= bk.getBooks()  %>">
   <li>
      <bean:write name="myBooks" property="authorName"/>:
      <bean:write name="myBooks" property="titel"/>
      (<bean:write name="myBooks" property="price"/>)
   </li>
   </logic:iterate>
</ol>


<%  
   java.util.Iterator i = bk.getBooks();
   List test2 = new ArrayList( 6 );
   while (i.hasNext())
   {
      Book b = (Book)i.next();
      test2.add(b.getAuthorName());
      out.println("<li>" + b.getAuthorName() + ":" 
      + b.getTitel() + " (");
      %><sw:preisFormat preis='<%=b.getPrice() %>' />)
      <a href="Warenkorb.jsp?option=add&isbn=<%=b.getIsbn()%>">
      <bean:message key="bookcatalogue.buy"/></a>
      </li><%
   }

%>
