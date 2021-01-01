<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<table border="1" width="100%">
 <tr>
   <td align="center"><a href='<%=response.encodeURL("AuthorCreate.jsp")%>'><bean:message 
   key="link.createauthor"/></a></td>
   
   <td align="center"><a href='<%=response.encodeURL("BookCreate.jsp")%>'><bean:message 
   key="link.createbook"/></a></td>

   <td align="center"><a href='<%=response.encodeURL("CustomerCreate.jsp")%>'><bean:message 
   key="link.createcustomer"/></a></td>
   
   <td align="center"><a href='<%=response.encodeURL("BookCatalogue.jsp")%>'><bean:message 
   key="link.viewCatalog"/></a></td>
 </tr>
</table>
<hr>

