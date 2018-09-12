// Java Document
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Login extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user="akshay";//request.getParameter("username");
		String pass="12345";//request.getParameter("password");
		String level=request.getParameter("level");
		System.out.println("connected");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("localhost/cms","root","");
			
			PreparedStatement ps=con.prepareStatement("select password from admin ");
			System.out.println("connected");
			
			ResultSet rs=ps.executeQuery();
			System.out.println("query suceeded");
			while(rs!=null){
				String password=rs.getString(2);
				System.out.println(password);
				if(pass==password){
					System.out.println("passed");
					break;
				}
				else
					rs.next();
			}
		}
		catch(Exception e2){
		e2.printStackTrace();	
		}
		finally{
			out.close();
		}
	}
}