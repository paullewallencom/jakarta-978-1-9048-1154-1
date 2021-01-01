<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html locale="true">
<head>
<html:base/>
<title>
<bean:message key="index.title"/>
</title>
</head>
<body>
<h2><bean:message key="index.title"/></h2>
<% out.println(request.getHeader("User-Agent")); %>
</body>
</html:html>

