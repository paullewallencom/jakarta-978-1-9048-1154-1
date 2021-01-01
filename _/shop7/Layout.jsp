<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:html locale="true">
<head><html:base/>
<title><bean:message key="index.title"/></title>
<link rel="stylesheet" href="java.css" type="text/css">
</head>

<body>
<tiles:insert attribute="head" />
<tiles:insert attribute="body" />
<tiles:insert attribute="foot" />
</body></html:html>
