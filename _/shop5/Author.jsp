<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page import="tools.*, book.Book"%>


<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("Author.jsp");
%>
 

<html:form action="createAuthor">
  
   <h2 class='error'><html:errors property="id"/></h2>
      <bean:message key="author.id"/>
      <html:text property="author.id" /> <br/>

   <h2 class='error'><html:errors property="firstname"/></h2>
      <bean:message key="author.firstname"/>
      <html:text property="author.firstname" /> <br/>
   
   <h2 class='error'><html:errors property="lastname"/></h2>
      <bean:message key="author.lastname"/>
      <html:text property="author.name" /> <br/>
   <html:submit property="submit"/>
   
</html:form>



