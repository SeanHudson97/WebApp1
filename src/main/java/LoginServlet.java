

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		session.setAttribute("username", username);
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTERDB","root", "root");
			PreparedStatement pst= conn.prepareStatement("Select name, password from LOGIN where name=? and password=?");
			
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				out.print("You are logged in");
				request.getRequestDispatcher("Welcome").include(request, response);
				
			}else {
				out.println("Username or Password incorrect");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			}catch (ClassNotFoundException | SQLException e ) {
				e.printStackTrace();
			
		}
		
		/**
		System.out.println("username: "+ username);
		if (password.equals("ee417"))
		{
			System.out.println("password: " +password);
		}
		else
		{
			System.out.println("Your Password is Incorrect, please try again");
			
			password = "Incorrect";
		}
		
		PrintWriter writer = response.getWriter();
		
		String htmlResponse = "<html>";
		htmlResponse += "<h2>Your Username is: " + username  +"<br/>";
		htmlResponse += "Your Password is: " + password +"</h2>";
		htmlResponse += "</html>";
		
		writer.println(htmlResponse);
		**/
		
		
		
		
		
		
		//doGet(request, response);
	}

}