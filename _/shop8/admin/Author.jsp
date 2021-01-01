<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page import="tools.*, book.Book"%>


<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("Author.jsp");
%>
 


 

<html:javascript formName="authorForm" page="1"/>


<br>
<html:form action="createAuthor" onsubmit="return validateAuthorForm(this);">>
   <html:errors property="author.id"/>
      <bean:message key="author.id"/>
      <html:text property="author.id" /> <br/>

   <html:errors property="author.firstname"/>
      <bean:message key="author.firstname"/>
      <html:text property="author.firstname" /> <br/>
   
   <html:errors property="author.name"/>
      <bean:message key="author.lastname"/>
      <html:text property="author.name" /> <br/>
   <html:submit property="submit"/>
</html:form>




