<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" />
<xsl:template match="web-app">

<html>
   <head>
      <title>Servlet Mappings web.xml</title>
      <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
   </head>
   <body>   
   <table border="1" cellpadding="2">
   <tr><th>Name</th><th>Class</th><th>Mapping</th></tr>
      <xsl:apply-templates select="*"/>
   </table> <br /> <br />
  </body></html> 
</xsl:template>

<xsl:template match="*">
</xsl:template>

<xsl:template match="//servlet">
  <tr>
     <xsl:variable name="servlet" select="servlet-name" />
     <td><xsl:value-of select="$servlet" /></td>
     <td><xsl:value-of select="servlet-class" /></td>
     <td>
     <xsl:value-of 
select="//servlet-mapping[servlet-name=$servlet]/url-pattern" />
     </td>
 </tr>
</xsl:template>
</xsl:stylesheet>
