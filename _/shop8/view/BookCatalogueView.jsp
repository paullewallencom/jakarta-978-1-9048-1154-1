<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://www.stephanwiesner.de/strutsbuch" prefix="sw" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page import="tools.*, book.*, java.util.*"%>

<fmt:setLocale value="de-DE" />

<h2 class="title"><bean:message key="bookcatalogue.title"/></h2>
   
<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("BookCatalogueView.jsp");
   BookCatalogue bk = new BookCatalogue();
   pageContext.setAttribute("bk2", new BookCatalogue().getBooks());
    

%> 

<ol>
<logic:iterate id="myBooks" name="bk2">
   <li>
      <bean:write name="myBooks" property="authorName"/>:
      <bean:write name="myBooks" property="titel"/>
      (<bean:write name="myBooks" property="price"/> Cents)
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
      + b.getTitel() + " (" + (b.getPrice()/100));
      %>
      )
      <a href="Shoppingcart.jsp?option=add&isbn=<%=b.getIsbn()%>">
      <bean:message key="bookcatalogue.buy"/></a>
      </li><%
   }

%>

<hr>

<ol>
<jsp:useBean id="kata" class="book.BookCatalogue" />
<c:forEach var="x" items="${kata.books}">
   <li>
      <c:out value="${x.authorName}" />:
      <c:out value="${x.titel}" />
      (<fmt:formatNumber value="${x.price/100}" 
         type="currency" currencySymbol="EUR"/>)
   </li>
</c:forEach>
</ol>


  

