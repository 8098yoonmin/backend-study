<%--
  Created by IntelliJ IDEA.
  User: yoonmin
  Date: 2023/05/02
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.nhnacademy.firstdbcp.utils.DBUtils" %>
<html>
<head>
  <title>reservation</title>
</head>
<body>
<table border="1">
  <tr>
    <td>번호</td>
    <td>항공편</td>
    <td>날짜</td>
  </tr>
  <%
    Connection connection = DBUtils.getDataSource().getConnection();
    String sqlQuery = "SELECT * FROM RESERVATION WHERE passengerNo= ?";
    PreparedStatement statement = connection.prepareStatement(sqlQuery);
    statement.setString(1, request.getParameter("id"));

    ResultSet result = statement.executeQuery();

    while(result.next()) {
      int id = result.getInt(1);
      int res = result.getInt(2);
      String date = String.valueOf(result.getDate(3));
  %>
  <tr>
    <td><a href="airinfo.jsp?id=<%=res%>"><%=id %></a></td>
    <td><%=res %></td>
    <td><%=date%></td>
  </tr>
  <%
    }
    result.close();
    statement.close();
    connection.close();
  %>
</table>


</body>
</html>
