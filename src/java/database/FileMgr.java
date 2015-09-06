/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author hy
 */
public class FileMgr {

    File path;

    public FileMgr(File path) {
        this.path = path;
    }

    public FileMgr(String path) {
        this(new File(path));
    }

    public void upload(HttpServletRequest request) throws Exception {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            List items = upload.parseRequest(request);
            Iterator iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = (FileItem) iterator.next();

                if (!item.isFormField()) {
                    String fileName = item.getName();

                    if (!path.exists()) {
                        boolean status = path.mkdirs();
                    }
                    String dir = path + "/" + fileName;

                    File uploadedFile = new File(dir);
                    if (!(uploadedFile.exists() && !uploadedFile.isDirectory())) {

                        //System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                    } else {
                        throw new Exception("File exist");
                    }
                }
            }

        }
    }

}
