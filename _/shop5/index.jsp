<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://www.stephanwiesner.de/strutsbuch" 
   prefix="sw" %>

<%@page import="tools.*"%>
   
   
<html:html locale="true">
<head><html:base/>
<title><bean:message key="index.title"/></title>
</head>
<body>
   <img src="pics/logo.jpg" alt="Welcome  in Struts Shop" >
   <br />
   <br /><br /><br /> 
   <bean:message key="general.copyright"/>
   <br /><sw:countryDate />
<%   
org.apache.commons.logging.Log log =           
   org.apache.commons.logging.LogFactory.getFactory().
   getInstance(this.getClass().getName());
log.error("hello ??");

java.util.logging.Logger logger = LoggerInitiator.getLogger();
logger.info("index.jsp functioning");


%>   


   
</body></html:html>

