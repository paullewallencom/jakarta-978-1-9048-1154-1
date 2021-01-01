<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html><head>
 <title>Formatting Example</title></head>
<body>

<fmt:setLocale value="de-DE" />
<c:set var="i2">12345</c:set>

<ul>
 <li><fmt:formatNumber value="12345.67" type="currency" 
  currencySymbol="EUR"/></li>
  
  <li><fmt:formatNumber value="${i2/100}" type="currency" 
  currencySymbol="EUR"/></li>
  <li>Nur schreiben:<c:out value="${i2}" /></li>
</ul>

<hr>

<jsp:useBean id="now" class="java.util.Date" />
Datum: <fmt:formatDate value="${now}" dateStyle="full" />

<hr>
Variablen: <br />
<%String stephan = "Stephan"; %>  


<jsp:useBean id="stephan2" class="java.lang.String" />
<c:set var="stephan2">Stephan</c:set>
<c:out value="${stephan2}" />
</body>
</html>