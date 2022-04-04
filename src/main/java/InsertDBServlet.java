import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertDBServlet
 */
@WebServlet("/InsertDBServlet")
public class InsertDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String JDBCUrl = "jdbc:mysql://localhost:3306/testdb";
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
		  PreparedStatement pstmt = con.prepareStatement("INSERT INTO EE417DBTEST.CUSTOMER_QUERY (FNAME, SNAME, PHONENUM, EMAIL, COUNTY) VALUES (?,?,?,?,?,?)");
				  pstmt.clearParameters();       // Clears any previous parameters
				  pstmt.setString(1, "Sean");
				  pstmt.setString(2, "Hudson");
				  pstmt.setString(3, "0871231234");
				  pstmt.setString(4, "sean.h@email.com");
				  pstmt.setString(5, "Dublin");
				  pstmt.executeUpdate();

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
	   		+ "            <th>COUNTY</th>\n"
	   		+ "         </tr>");
	     while (rs.next())
	     {   out.println("\n <tr>");
	     	out.println("<td>" + rs.getString("FNAME") + "<td/>");
	     	out.println("<td>" + rs.getString("SNAME") + "<td/>");
	     	out.println("<td>" + rs.getString("PHONENUM") + "<td/>");
	     	out.println("<td>" + rs.getString("EMAIL") + "<td/>");
	     	out.println("<td>" + rs.getString("COUNTY") + "<td/>");
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

}
