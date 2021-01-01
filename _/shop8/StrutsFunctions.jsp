<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>



<%@ page import="org.apache.struts.action.*,
                 java.util.Iterator,
                 struts.*, book.*, tools.*"%>

<%  
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   logger.info("StrutsFunctions.jsp");
%>


<html><head><title>Different Struts Functions</title>
</head>

<body>
<h2>Different Struts Functions</h2>

<html:form action="upload" enctype="multipart/form-data">
	Please select the file that you would like to upload:<br />
	<html:file property="theFile" /><br /><br />
	<html:submit />
</html:form>


<hr />

<%
Book b[] = new Book[3];
b[0] = new Book();
b[0].setTitel("Book 0");
b[1] = new Book();
b[1].setTitel("Book 1");
b[2] = new Book();
b[2].setTitel("Book 2");
%>
<ol>
   <logic:iterate id="myBooks" collection="<%= b %>">
   <li><bean:write name="myBooks" property="titel"/></li>
   </logic:iterate>
</ol>


</body></html>

 