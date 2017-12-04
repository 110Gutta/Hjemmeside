package fileManagement;

import java.io.File;
import javax.ejb.Local;
import java.util.List;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author nilsf
 */

@Local
public interface FileManagerLocal {
    File getFile(String mergedNrEmail);
    List getListFromQuery(String query, Class<File> fileClass);
    Query createQuery(String query);
    boolean saveFile(File file);
    boolean updateFile(File file, HttpServletRequest request, HttpServletResponse response);
}