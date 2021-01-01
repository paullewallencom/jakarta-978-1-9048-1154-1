

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="Layout.jsp" flush="true">
<tiles:put name="head" value="Header.jsp" />
<tiles:put name="book" value="Book.jsp" />

<tiles:put name="foot" value="Footer.jsp" />
<tiles:put name="author" value="Author.jsp" />
</tiles:insert>