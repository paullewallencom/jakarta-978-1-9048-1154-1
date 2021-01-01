<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://www.stephanwiesner.de/strutsbuch"
prefix="sw" %>
<%@page import="tools.*"%>
<html:html locale="true">
<head><html:base/>
<title><bean:message key="index.title"/></title>
</head>
<body>
<tiles:insert attribute="head" />
<tiles:insert attribute="body" />
<tiles:insert attribute="foot" />
</body></html:html>




