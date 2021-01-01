<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="tools.*, customer.Customer"%>

<h2 class="title"><bean:message key="customer.title"/></h2>

   
<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("Customer.jsp");
%>


<html:form action="createCustomer" method="POST">

<table border="1">      
   <tr><td><bean:message key="author.firstname"/></td>
   <td><html:errors property="firstname"/>
   <html:text property="customer.firstname" /> </td></tr>
   
   <tr><td><bean:message key="author.lastname"/></td>
   <td><html:errors property="lastname"/>
   <html:text property="customer.name" /> </td></tr>
      
   <tr><td><bean:message key="general.password"/></td>
   <td><html:errors property="password"/>
   <html:password property="customer.password" /></td></tr>
      
   <tr><td><bean:message key="general.mail"/></td>
   <td><html:errors property="mail"/>
   <html:text property="customer.mail" /></td></tr> 

   <tr><td><bean:message key="general.street"/></td>
   <td><html:errors property="street"/>
   <html:text property="customer.street" /></td></tr> 
      
   <tr><td><bean:message key="general.housenumber"/></td>
   <td><html:errors property="housenumber"/>
   <html:text property="customer.housenumber" /> </td></tr>

   <tr><td><bean:message key="general.zipcode"/></td>
   <td><html:errors property="zipcode"/>
   <html:text property="customer.zipcode" /> </td></tr>

   <tr><td><bean:message key="general.city"/></td>
   <td><html:errors property="city"/>
   <html:text property="customer.city" /> </td></tr>
</table>   
      
   <html:submit property="submit"/>
</html:form>

</body></html:html>