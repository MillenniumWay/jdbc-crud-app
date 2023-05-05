<%@ page import="java.io.PrintWriter" %>
<%@ page import="DAO_LAYERS.ClientsDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Service.ClientService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="table.css" rel="stylesheet" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Space+Grotesk&display=swap" rel="stylesheet">
</head>
<body>
<c:set var="taglibsshhitt" value="Welcome!" scope="page" ></c:set>
<% PrintWriter printWriter = response.getWriter();
      String login = (String) session.getAttribute("login");
      String email = (String) session.getAttribute("email");
       ClientService clientService = new ClientService();
       Cookie[] cookies = request.getCookies();
       for (Cookie cookie: cookies) {
           System.out.println(cookie.getValue());
          if (login != null) {
              printWriter.write("<a href=\"/registration\" style=\"font-size: 20px\"> SignUp</a> <br>\n" +
                      "<a href=\"/login\"style=\"font-size: 20px\"> Login</a> <br> \n" +
                      "<a href=\"/DeleteCookieServlet\"style=\"font-size: 20px\">LogOut</a> <br> \n" +
                      "<a href=\"/CheckCookiesServlet\"style=\"font-size: 20px\">Check Session/Cookies</a> <br>");

              printWriter.write("<center> <p style=\"font-size: 24px\"> Welcome " + login +  "!" + "</p>" +
                      "<p style=\"font-size: 24px\">" +
                      "login: "+ login + "<br/>" + " " +
                      "email: "+ email + "<br/>"  + " " + "</p></center>");
              printWriter.write("<div  style=\"position: relative; left: auto; right: -1325px;\" >\n" +
                      "<form action=\"/index\" method=\"post\"> ");

              printWriter.write("   " +
                      "     <label for=\"FIRSTNAME\"> First Name:\n" +
                      "            <input type=\"text\" name=\"FIRSTNAME\" id=\"FIRSTNAME\">\n" +
                      "        </label><br/><br/>\n" +
                      "\n" +
                      "        <label for=\"LASTNAME\">Last Name:\n" +
                      "            <input type=\"text\" name=\"LASTNAME\" id=\"LASTNAME\">\n" +
                      "        </label><br/><br/>\n" +
                      "\n" +
                      "        <label for=\"PASSPORT\">Passport:\n" +
                      "            <input type=\"text\" name=\"PASSPORT\" id=\"PASSPORT\">\n" +
                      "        </label><br/><br/>\n" +
                      "\n" +
                      "        <label for=\"CODE\">Code:\n" +
                      "         <input type=\"text\" name=\"CODE\" id=\"CODE\">\n" +
                      "        </label><br/><br/>\n" +
                      "\n" +
                      "        <label for=\"DATE\">Date Entry:\n" +
                      "            <input type=\"text\" name=\"DATE\" id=\"DATE\">\n" +
                      "        </label><br/><br/>\n" +
                      "\n" +
                      "        <label for=\"FK_DOC\">Doctor ID:\n" +
                      "            <input type=\"text\" name=\"FK_DOC\" id=\"FK_DOC\">\n" +
                      "        </label><br/><br/>\n" +
                      "\n" +
                      "        <input type=\"submit\" value=\"#INSERT#\">\n" );

              printWriter.write("</form>" +
                              "</div>");

              clientService.jspShowTable(request,response);

           }

          else {
              System.out.println("False ?? : " + login);
              printWriter.write("<center> <h1> Welcome User! </h1> <br></center>");
          }
       }
       System.out.println(login);
%>
<form action="/index" method="post">   </form>

</body>
</html>


