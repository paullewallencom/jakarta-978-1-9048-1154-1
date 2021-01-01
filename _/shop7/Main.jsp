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


MAIN <br>

The session has stored following time:
<%= session.getAttribute("zeit") %>

</body></html:html>

