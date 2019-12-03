

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class VoterApp
 */
@WebServlet("/vote")
public class VoterApp extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public VoterApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n=request.getParameter("name");
		String a=request.getParameter("age");
		int age=Integer.parseInt(a);
		PrintWriter pw=response.getWriter();
		if(age>18)
		{
			pw.print("welcome to voting system "+n);
			pw.print(n+"you are eligible for voting");
			
		}
		else
		{
			pw.print("you are not eligible for voting");
		}
		
	}

}
