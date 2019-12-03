

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        //out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Students List</h1>");  
          
        List<Student> list=StudentDao.getAllStudents();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>PRN</th><th>Name</th><th>Subject1</th><th>Subject2</th><th>Subject3</th></tr>");  
        for(Student s:list){  
         out.print("<tr><td>"+s.getPRN()+"</td><td>"+s.getName()+"</td><td>"+s.getS1()+"</td> <td>"+s.getS2()+"</td><td>"+s.getS3()+"</td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
