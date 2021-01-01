<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://www.stephanwiesner.de/strutsbuch" prefix="sw" %>

<%@page import="tools.*, book.Book"%>


<html:html locale="true">
<head><html:base/>
<title>Book VIEW</title>
</head>
<body>
   
<% 
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("BookView.jsp");
%>
Success!

<br />

<hr>
<html:errors />
<hr>

<br /><a href='<%=response.encodeURL("../BookCreate.jsp")%>'>New Book Created</a>


</body></html:html>