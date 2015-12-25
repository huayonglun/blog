package boke.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�ļ�����·��
				ServletContext context = request.getServletContext();
				String path = context.getInitParameter("file-upload");
				//String filename=request.getParameter("filename");
				String filename=new String(request.getParameter("filename").getBytes("ISO-8859-1"),"UTF-8");
				File file = new File(path+filename);
				System.out.println(filename);
				if(file.exists()){
					//������Ӧ����application/octet-stream
					response.setContentType("application/x-msdownload");
					//����ͷ��Ϣ
					//response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
					response.setHeader("Content-Disposition", "attachment;filename=\""+new String(filename.getBytes("UTF-8"),"iso8859-1")+"\"");
					InputStream inputStream=new FileInputStream(file);
					ServletOutputStream outputStream=response.getOutputStream();
					byte b[]=new byte[1024];
					int n;
					while((n=inputStream.read(b))!=-1){
						outputStream.write(b, 0, n);
					}
					
					//�ر������ͷ���Դ
					outputStream.close();
					inputStream.close();
				}else{
					request.setAttribute("errorResult", "�ļ�����������ʧ��");
					System.out.println("error");
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
