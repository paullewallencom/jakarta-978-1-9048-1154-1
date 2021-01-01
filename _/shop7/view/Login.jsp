<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="tools.*, customer.*"%>
<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("Login.jsp");
%>
<bean:message key="login.title"/>
<html:form action="/login" focus="mail">
   <bean:message key="general.mail"/>
      <html:text property="mail" size="20" /> <br />
   <bean:message key="general.password"/>
      <html:text property="password" size="20" /><br />
   <html:submit value="Enter" />
</html:form>

<br /><a href='<%=response.encodeURL("../CustomerCreate.jsp")%>'>
<bean:message key="link.createcustomer" /></a>
