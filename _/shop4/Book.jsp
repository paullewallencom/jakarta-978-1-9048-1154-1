<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://www.stephanwiesner.de/strutsbuch" prefix="sw" %>

<%@page import="tools.*, book.Book"%>


<html:html locale="true">
<head><html:base/>
<title><bean:message key="index.title"/></title>
</head>
<body>
<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("Book.jsp");
%>



<html:errors /> 
<html:form action="createBook.do" method="GET">
   <html:errors property="title"/>
      <bean:message key="general.title"/>
      <html:text property="book.titel" /> <br/>

   <html:errors property="author"/>
      <bean:message key="general.author"/>
      <html:text property="book.author" /> <br/>

   <html:errors property="isbn"/>
      <bean:message key="general.isbn"/>
      <html:text property="book.isbn" /> <br/>
      
   <html:errors property="price"/>
      <bean:message key="general.price"/>
      <html:text property="book.price" /> <br/>

   <html:submit property="submit"/>
</html:form>

</body></html:html>