<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,be.softwarelab.entity.Users"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JPA Guest Book Web Application Tutorial</title>
    </head>

    <body>

        <h1>Hello World! - JPA page</h1>
        
        <div>
            <a href="index.html">index.html</a> - 
            <a href="index.jsp">index.jsp</a> - 
            <a href="index.xhtml">index.xhtml</a> - 
            <a href="message.xhtml">message.xhtml</a> - 
            <a href="primefaces.xhtml">primefaces.xhtml</a> - 
            <a href="welcomePrimefaces.xhtml">welcomePrimefaces.xhtml</a> - 
            <a href="crazyform.xhtml">crazyform.xhtml</a> - 
            <a href="UsersServlet">users.jsp</a>
        </div>

        <form method="POST" action="MessageDBServlet">
            ID: <input type="text" name="id" />
            <input type="submit" value="Add" />
        </form>

        <hr><ol> <%
            @SuppressWarnings(  "unchecked")
            List<Users> users = (List<Users>) request.getAttribute("users");
            if (users != null) {
                for (Users user : users) {%>
            <li> <%= user.getId() %> - <%= user.getName() %> </li> <%
                            }
                        }%>
        </ol><hr>

    </body>
</html>