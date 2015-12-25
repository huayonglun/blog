package boke.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import boke.service.ResourceManager;
import boke.service.impl.ResourceManagerImpl;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ϴ������ݱ��봦��
		String rtname=new String(req.getParameter("rtname").getBytes("ISO-8859-1"),"UTF-8"); 
		String rname=new String(req.getParameter("rname").getBytes("ISO-8859-1"),"UTF-8");
		String uploader=new String(req.getParameter("uploader").getBytes("ISO-8859-1"),"UTF-8");
		Date date=new Date();
		String uploaddate=(date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate()+"  "+date.getHours()+":"+date.getMinutes();
		System.out.println(rname+":"+uploader+":"+rtname+":"+uploaddate);
		File file ;
		   int maxFileSize = 300 * 1024*1024;
		   int maxMemSize = 5000 * 1024;
		   ServletContext context = req.getServletContext();
		   String filePath = context.getInitParameter("file-upload");
		   WebApplicationContext context1=WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		   // ��֤�ϴ�����������
		   String contentType = req.getContentType();
		   System.out.println(contentType);
		   if ((contentType.indexOf("multipart/form-data") >= 0)) {

		      DiskFileItemFactory factory = new DiskFileItemFactory();
		      // �����ڴ��д洢�ļ������ֵ
		      factory.setSizeThreshold(maxMemSize);
		      // ���ش洢�����ݴ��� maxMemSize.
		      factory.setRepository(new File("c:\\temp"));

		      // ����һ���µ��ļ��ϴ��������
		      ServletFileUpload upload = new ServletFileUpload(factory);
		      // ��������ϴ����ļ���С
		      upload.setSizeMax( maxFileSize );
		      try{ 
		         // ������ȡ���ļ�
		         List fileItems = upload.parseRequest(req);

		         // �����ϴ����ļ�
		         Iterator i = fileItems.iterator();
		         
		         resp.setCharacterEncoding("UTF-8");
		         while ( i.hasNext () ) 
		         {
		            FileItem fi = (FileItem)i.next();
		            if ( !fi.isFormField () )	
		            {
		            
		            // ��ȡ�ϴ��ļ��Ĳ���
		            String fieldName = fi.getFieldName();
		            
//		            String fileName = fi.getName();
		            String fileName=rname;
		          //���ϴ����ļ������б��봦��
//		            fieldName=new String(fieldName.getBytes("ISO-8859-1"),"UTF-8");
//		            fileName=new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		           
		            System.out.println(fieldName+":"+fileName);
		            boolean isInMemory = fi.isInMemory();
		            long sizeInBytes = fi.getSize();
		            // д���ļ�
		            if( fileName.lastIndexOf("\\") >= 0 ){
		            file = new File( filePath , 
		            fileName.substring( fileName.lastIndexOf("\\"))) ;
		            }else{
		            file = new File( filePath ,
		            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		            }
		            
		            fi.write( file ) ;
		            
		            resp.getWriter().println("�ϴ��ɹ�!");
		            }
		            
		         }
		         
		      ResourceManager rm = (ResourceManager)context1.getBean("resourceManager");
		      boolean flag=rm.insertResource(rname, uploader, uploaddate, rtname);
		      System.out.println(flag);
		      }catch(Exception ex) {
		         System.out.println(ex);
		      }
		   }else{
				resp.getWriter().println("�ϴ�ʧ��!");
		   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
