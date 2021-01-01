<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>


<%@page import="tools.*, book.Book"%>


<html:html locale="true">
<head><html:base/>
<title><bean:message key="author.title"/></title>
</head>
<body>
  Success!
<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("CustomerView.jsp");
%>

<br /><a href='<%=response.encodeURL("../index.jsp")%>'>Home</a>
</body></html:html>