

<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<table border="1" width="100%">
<tr>
<td align="center"><a href='<%=response.encodeURL
("AuthorCreate.jsp")%>'><bean:message
key="link.createauthor"/></a></td>
<td align="center"><a href='<%=response.encodeURL("BookCreate.jsp")%>'><bean:message
key="link.createbook"/></a></td>
</tr>
</table>
<hr>
