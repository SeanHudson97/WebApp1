<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>
   <head>
      <title>SELECT Operation</title>
   </head>

   <body>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/testdb"
         user = "root"  password = "Omitted"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
SELECT FNAME, SNAME, PHONENUM, EMAIL, COUNTY FROM EE417DBTEST.CUSTOMER_QUERY      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>FNAME</th>
            <th>SNAME</th>
            <th>PHONENUM</th>
            <th>EMAIL</th>
            <th>COUNTY</th>
         </tr>
        <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.FNAME}"/></td>
               <td><c:out value = "${row.SNAME}"/></td>
               <td><c:out value = "${row.PHONENUM}"/></td>
               <td><c:out value = "${row.EMAIL}"/></td>
               <td><c:out value = "${row.COUNTY}"/></td>
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>