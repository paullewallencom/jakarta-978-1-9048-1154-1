<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://www.stephanwiesner.de/strutsbuch" prefix="sw" %>

<%@page import="tools.*, book.Book"%>


<html:html locale="true">
<head><html:base/>
<title><bean:message key="author.title"/></title>
</head>
<body>
   AUTHOR VIEW
<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("Author.jsp");
%>
All: <html:errors/>
<br>
Single:<html:errors property="general.id.max" /><br>

Success!
<br /><a href='<%=response.encodeURL("../AuthorCreate.jsp")%>'>New Author created</a>

</body></html:html>