<%@ page import="java.sql.*" %>
<%
  // Read RDS connection information from the environment
  String dbName = "EE417DBTEST";
  String userName = "root";
  String password = "omitted";
  String hostname = "localhost";
  String port = "3306";
  String jdbcUrl = "jdbc:mysql://" + hostname + ":" +
    port + "/" + dbName + "?user=" + userName + "&password=" + password;
  
  // Load the JDBC driver
  try {
    System.out.println("Loading driver...");
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver loaded!");
  } catch (ClassNotFoundException e) {
    throw new RuntimeException("Cannot find the driver in the classpath!", e);
  }

  Connection conn = null;
  Statement setupStatement = null;
  Statement readStatement = null;
  ResultSet resultSet = null;
  String results = "";
  int numresults = 0;
  String statement = null;

  String q = "SELECT FNAME, SNAME, PHONENUM, EMAIL, COUNTY FROM EE417DBTEST.CUSTOMER_QUERY; ";
  out.print(q);
  try {
    conn = DriverManager.getConnection(jdbcUrl);
    
    readStatement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    resultSet = readStatement.executeQuery("SELECT FNAME, SNAME FROM EE417DBTEST.CUSTOMER_QUERY");
    resultSet.first();
    while(resultSet.next()!=false)
    {
    results = resultSet.getString("FNAME") + resultSet.getString("SNAME");
    out.println("Result is" + results);
    resultSet.next();
    results += ", " ;
    }
    resultSet.close();
    readStatement.close();
    conn.close();

  } catch (SQLException ex) {
    // Handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
  } finally {
       System.out.println("Closing the connection.");
      if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
  }
%>