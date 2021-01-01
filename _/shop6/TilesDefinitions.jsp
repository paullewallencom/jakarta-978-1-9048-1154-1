<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:definition id="Author" page="/Layout.jsp"
extends="BasisLayout">
<tiles:put name="body" value="/admin/Author.jsp" />
</tiles:definition>
<tiles:definition id="Book" page="/Layout.jsp"
extends="BasisLayout">
<tiles:put name="body" value="/admin/Book.jsp" />
</tiles:definition>