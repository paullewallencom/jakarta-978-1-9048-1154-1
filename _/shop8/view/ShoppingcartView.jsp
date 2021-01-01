<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="tools.*, customer.*"%>
<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("ShoppingcartView.jsp");
%>
<h2><bean:message key="shoppingcart.title"/></h2>
<%
   Customer customer = (Customer) session.getAttribute("customer");
   if (customer == null)
   {
      %><bean:message key="shoppingcart.pleaseLogin"/><%
      return;
   }
   
   Shoppingcart wk = new Shoppingcart();
   String option = request.getParameter("option");
   if (option != null)
   {
      if (option.equals("add"))
      {
         String isbn = request.getParameter("isbn");
         if (isbn ==  null)
         {
            %><bean:message key="shoppingcart.missingISBN"/><%
            return;
         }
         wk.add(customer.getId(), Integer.parseInt(isbn), 1);
         %><bean:message key="general.book"/>&nbsp;
         <%=isbn%>
         <bean:message key="shoppingcart.added"/><%
      }
   }
%>

<ol>
   <logic:iterate id="shoppingcart" 
      collection="<%= wk.load(customer.getId()) %>">
      <li>
         <bean:write name="shoppingcart" property="author"/>:
         <bean:write name="shoppingcart" property="book"/>=
         <bean:write name="shoppingcart" property="price"/>
      </li>
   </logic:iterate>
</ol>



