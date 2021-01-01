package struts;



import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;
import tools.*;
/**
  Adaption of the UploadAction from the Struts download.
*/
public class UploadAction extends Action
{
   java.util.logging.Logger logger = LoggerInitiator.getLogger();
   
   
   public ActionForward execute(ActionMapping mapping,
      ActionForm form, HttpServletRequest request,
      HttpServletResponse response) throws Exception
   {
      UploadForm theForm = (UploadForm) form;
      // retrieve the file representation
      FormFile file = theForm.getTheFile();
        
      try
      {
         InputStream stream = file.getInputStream();
         byte[] buffer = new byte[file.getFileSize()];
         stream.read(buffer);
         stream.close();
         HttpSession session = request.getSession(true);
         session.setAttribute("file", buffer);
         session.setAttribute("mime", file.getContentType());         
      } catch (FileNotFoundException fnfe)
      {
         logger.severe("FileNotFoundException:" + fnfe);
         return null;
      } catch (IOException ioe)
      {
         logger.severe("IOException:" + ioe);
         return null;
      }
      //destroy the temporary file created
      file.destroy();
      return mapping.findForward("uploadSuccess");
   }
}
