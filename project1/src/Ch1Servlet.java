import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.*;
public class Ch1Servlet extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res){

	PrintWriter pw=null;
	try {
		pw = res.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		ServletConfig config=getServletConfig(); 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection c=DriverManager.getConnection(config.getInitParameter("url"),config.getInitParameter("name"),config.getInitParameter("pass"));
		Statement stmt =  c.createStatement();
		String sql = "INSERT INTO name " +"VALUES ('"+ req.getParameter("nm")+"','"+ req.getParameter("pass")+"')";
      stmt.executeUpdate(sql);
			
					
			}  catch (Exception e) {

				
			}
			String name=req.getParameter("nm");
			String pass=req.getParameter("pass");
	pw.println("<h1><body bgcolor='cyan'> inserted name = "+name+"    password =    "+pass);





}
}