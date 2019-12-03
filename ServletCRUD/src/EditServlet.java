

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		out.print("<h1>Update Employee</h1>");
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Employee e=EmpDao.getEmployeeById(id);
		
		out.print("<form action='EditServlet2' method='post'>");  
//        out.print("<table>");  
        out.print("<input type='hidden' name='id' value='"+e.getId()+"'/><br>");  
        out.print("Name:<input type='text' name='name' value='"+e.getName()+"'/><br>");  
        out.print("Password:<input type='password' name='password' value='"+e.getPassword()+"'/> <br>");  
        out.print("Email:<input type='email' name='email' value='"+e.getEmail()+"'/></br>");  
        out.print("Country:");  
        out.print("<select name='country' style='width:150px'>");  
        out.print("<option>India</option>");  
        out.print("<option>USA</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        //out.print("</td></tr>");  
        out.print("<input type='submit' value='Edit & Save '/></br>");  
        //out.print("</table>");  
        out.print("</form>");  
          
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
