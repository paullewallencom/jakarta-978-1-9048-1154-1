<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" />

<xsl:variable name="server" select="'http://127.0.0.1:8080/crs'"/>

<!-- Head *********** -->
<xsl:template match="struts-config">

<html>
   <head>
      <title>Struts Forward Definitions</title>
      <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
   </head>
   <body>
   <xsl:apply-templates select="*"/>
  </body></html>
</xsl:template>

<xsl:template match="*">
</xsl:template>

<xsl:template match="//global-forwards">
   <h2>Forwards</h2>
   <table border="1">
   <tr><th>Link</th><th>Files</th></tr>
   <xsl:apply-templates select="*"/>
   </table> <br /> <br />
</xsl:template>

<xsl:template match="forward">
  <tr>
     <td><xsl:value-of select="@name" /></td>
     <td>      
      <a><xsl:attribute name="href"><xsl:value-of 
      select="$server"/><xsl:value-of 
      select="@path" /></xsl:attribute>
      <xsl:value-of select="@path" />
      </a>
     </td>
 </tr>
</xsl:template>


<!-- ************************************************** -->

<xsl:template match="//form-beans">
   <h2>Form-Beans</h2>
   <table border="1">
   <tr><th>Name</th><th>Klasse</th></tr>
   <xsl:apply-templates select="*"/>
   </table> <br /> <br />
</xsl:template>

<xsl:template match="form-bean">
  <tr>
     <td><xsl:value-of select="@name" /></td>
     <td> <xsl:value-of select="@type" /></td>     
 </tr>
</xsl:template>




<!-- ************************************************** -->

<xsl:template match="//action-mappings">
   <h2>Action-Mappings</h2>
   <table border="1">
   <tr><th>Name</th><th>Pfad</th></tr>
   <xsl:apply-templates select="*"/>
   </table> <br /> <br />
</xsl:template>

<xsl:template match="action">
  <tr>
     <td><xsl:value-of select="@name" /></td>
     <td> <xsl:value-of select="@path" />:
     <table border="0">
	<xsl:apply-templates select="*"/>     
     </table>
     </td>     
 </tr>
</xsl:template>


<xsl:template match="action/forward">
  <tr><td><xsl:value-of select="@name" /></td>
  <td> ==&gt; 
      <a><xsl:attribute name="href"><xsl:value-of 
      select="$server"/><xsl:value-of 
      select="@path" /></xsl:attribute>
      <xsl:value-of select="@path" />
      </a>  

  </td></tr>
</xsl:template>

</xsl:stylesheet>
