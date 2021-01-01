<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://www.stephanwiesner.de/strutsbuch" 
   prefix="sw" %>

<%@page import="tools.*"%>
   
   
<html:html locale="true">
<head><html:base/>
<title><bean:message key="index.title"/></title>
<link rel="stylesheet" href="java.css" type="text/css">
</head>
<body>
   <img src="pics/logo.jpg" alt="Welcome in Struts Shop" >
   <br />

   <%
      //HttpSession session = request.getSession(true);
      session.setAttribute("zeit", new java.util.Date());
   %>
   <br /><a href='<%=response.encodeURL("BookCatalogue.jsp")%>'>Enter</a>

   <br /><br /><br /> 
   <bean:message key="general.copyright"/>
   <br /><sw:countryDate />

   

   
<%   
java.util.logging.Logger logger = LoggerInitiator.getLogger();
logger.info("index.jsp functioning");
%>   
  
</body></html:html>

