<%@page import="java.io.*, tools.*"%>

<h2>Logging</h2>
<%   
/**
   @author stephan@stephan-wiesner.de
   @version 0.1
*/

      File inputFile = new File(PropertiesSingleton.getInstance().
         getProperty("log.file"));
      FileReader fr = new FileReader(inputFile);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      int ch;
      while((ch = fr.read()) != -1) {
         baos.write(ch);
      }
      byte[] content = baos.toByteArray();
      
      response.setContentType("text/html");
      response.setContentLength(content.length);
      response.getOutputStream().write(content);
      response.getOutputStream().flush();

%>      

