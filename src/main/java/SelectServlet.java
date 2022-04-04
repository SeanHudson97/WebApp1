import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.PreparedStatement;
import java.sql.*;
//import com.mysql.*;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String JDBCUrl = "jdbc:mysql://localhost:3306/EE417DBTEST";
        String username = "root";
        String password = "Omitted";
        PrintWriter out = response.getWriter();
        try {
            System.out.println("\nConnecting to the SSD Database......");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBCUrl, username, password);
        }
        catch (Exception e) {
            System.out.println("\nAn error has occurred during the connection phase!  This is most likely due to your CLASSPATH being set wrong and the"
                    + "  classes unable to be found.  Otherwise the database itself may be down.  Try telneting to port 3306 and see if it is up!");
            e.printStackTrace();
            System.exit(0);
        }   

	 try {
	     System.out.println("\nConnection Successful..... creating statement....");
     	     stmt = con.createStatement();
	     rs = stmt.executeQuery("SELECT * FROM EE417DBTEST.CUSTOMER_QUERY");

	     response.setContentType("text/html");
	     out.println("\n <html><body><table border='1'>");
	   out.println("<tr>\n"
	   		+ "            <th>FNAME</th>\n"
	   		+ "            <th>SNAME</th>\n"
	   		+ "            <th>PHONENUM</th>\n"
	   		+ "            <th>EMAIL</th>\n"
	   		+ "            <th>COUNTY/th>\n"
	   		+ "         </tr>");
	     while (rs.next())
	     {   out.println("\n <tr>");
	     	out.println("<td>" + rs.getInt("FNAME") + "</td>");
	     	out.println("<td>" + rs.getString("SNAME") + "</td>");
	     	out.println("<td>" + rs.getString("PHONENUM") + "</td>");
	     	out.println("<td>" + rs.getString("EMAIL") + "</td>");
	     	out.println("<td>" + rs.getString("COUNTY") + "</td>");
	     	out.println("</tr>");
	     }
	     out.println("</table></body></html>");
	     }
        catch (SQLException e) {
	     System.out.println("\nAn error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
            while (e != null) {
	         System.out.println(e.getMessage());
                e = e.getNextException();
	     }
            System.exit(0);
        }

        finally {
	     try {    
	         if (rs != null) rs.close();
		 if (stmt != null) stmt.close();
		 if (con != null) con.close();
	     }
	     catch (Exception ex) {
	         System.out.println("An error occurred while closing down connection/statement"); 
            }
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
