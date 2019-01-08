package com.fasoo.sem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

public class UNRESTRICTED_UPLOAD_OF_FILE_TestCase extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        /* Check if it has been sent as a multipart */
        /*
         * Reference:
         * http://www.albumbang.com/board/board_view.jsp?board_name=free&no=292
         */
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/upload");
        File dir = new File(path);
        if (!dir.exists())
            dir.mkdir();
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (item.getFieldName().equals("file")) {
                        String FileNametemp = item.getName();
                        StringTokenizer st = new StringTokenizer(FileNametemp, "\\");
                        while (st.hasMoreTokens()) {
                            FileNametemp = st.nextToken();
                        }
                        File uploadFile = new File(dir, FileNametemp);
                        /* FLAW */
                        item.write(uploadFile); /* BUG */
                    }
                }
            } catch (FileUploadException e) {
                throw new FileUploadException("File Upload Exception has been occurred");
            }
        }
    }

    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/upload");
        File dir = new File(path);
        if (!dir.exists())
            dir.mkdir();
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    String FileName = "";
                    String FileNametemp = "";
                    if (item.getFieldName().equals("file")) {
                        FileNametemp = item.getName();
                        StringTokenizer st = new StringTokenizer(FileNametemp, "\\");
                        while (st.hasMoreTokens()) {
                            FileNametemp = st.nextToken();
                        }
                    }

                    /* FIX */
                    if (FileNametemp != null && !((FileNametemp.endsWith(".asp") || FileNametemp.endsWith(".jsp") || FileNametemp.endsWith(".html") || FileNametemp.endsWith(".htm") || FileNametemp.endsWith(".php")))) {
                        File uploadFile = new File(dir, FileName);
                        item.write(uploadFile); /* NOT BUG */
                    }
                }
            } catch (FileUploadException e) {
                throw new FileUploadException("File Upload Exception has been occurred");
            }
        }
    }

    public void bad2(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* Read data using an outbound tcp connection */
            sock = new Socket("192.168.0.100", 39500);

            /* read input from socket */
            instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
            buffread = new BufferedReader(instrread);

            data = buffread.readLine();
            data = null;
        } catch (IOException ioe) {
        } finally {
            // clean up stream reading objects //
            try {
                if (buffread != null) {
                    buffread.close();
                }
            } catch (IOException ioe) {
            }

            try {
                if (instrread != null) {
                    instrread.close();
                }
            } catch (IOException ioe) {
            }

            // clean up socket objects //
            try {
                if (sock != null) {
                    sock.close();
                }
            } catch (IOException e) {
            }
        }

        int maxPostSize = 10 * 1024 * 1024; // 10MB
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/upload");
        File dir = new File(path);
        if (!dir.exists())
            dir.mkdir();
        MultipartRequest multi = new MultipartRequest(request, dir.toString(), maxPostSize, "utf-8");

        Enumeration formNames = multi.getFileNames();

        String fileInput = "";
        String fileName = "";
        String type = "";
        File fileObj = null;
        String originFileName = "";
        String fileExtend = "";
        String fileSize = "";

        while (formNames.hasMoreElements()) {
            fileInput = (String) formNames.nextElement();
            fileName = multi.getFilesystemName(fileInput);
            if (fileName != null) {
                type = multi.getContentType(fileInput);
                fileObj = multi.getFile(fileInput);
                /* FLAW */
                originFileName = multi.getOriginalFileName(data + fileInput); /* SAFE */// TODO
                fileExtend = fileName.substring(fileName.lastIndexOf(".") + 1);
                fileSize = String.valueOf(fileObj.length());
            }
        }

    }

}
