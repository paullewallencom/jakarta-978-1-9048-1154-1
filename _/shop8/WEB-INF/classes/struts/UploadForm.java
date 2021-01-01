package struts;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;



/**
  Adaption of the UploadAction from the Struts download.
*/
public class UploadForm extends ActionForm
{
    /**
     * The file that the user has uploaded
     */
    protected FormFile theFile;
    protected String filePath = "";

    /**
     * Retrieve a representation of the file the user has uploaded
     */
    public FormFile getTheFile() { return theFile;  }

    /**
     * Set a representation of the file the user has uploaded
     */
    public void setTheFile(FormFile theFile) 
    { this.theFile = theFile; }


    /**
     * Set the path to write a file to
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Get the path to write a file to
     */
    public String getFilePath() {
        return filePath;
    }

    public void reset() 
    {
       theFile = null;
       filePath = "";
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
       return null;
    }
}
