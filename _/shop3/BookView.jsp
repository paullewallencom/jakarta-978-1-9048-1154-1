<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page import="tools.*"%>
<%   
java.util.logging.Logger logger = LoggerInitiator.getLogger();
logger.info("Book.jsp");
%>   
   
   
<html:html locale="true">
<head><html:base/>
<title><bean:message key="index.title"/></title>
</head>
<body>

BOOK VIEW!!!

<html:form action="createBook" method="GET">
Titel:<html:text property="title" /> <br/>
<html:submit property="submit"/>
</html:form>


   
</body></html:html>

