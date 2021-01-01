<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<h2>
<bean:message key="<%=(String)session.getAttribute("error")%>"/>
</h2>