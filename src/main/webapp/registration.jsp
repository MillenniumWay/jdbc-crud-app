<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
    <center><label for="name">Name:
        <input type="text" name="name" id="name">
    </label><br/>
    <label for="email">Email:
        <input type="text" name="email" id="email">
    </label><br/>
    <label for="pwd">Password:
        <input type="password" name="pwd" id="pwd">
    </label><br/>
    <input type="submit" value="Send">
    </center>
</form>


<c:if test="${not empty requestScope.errors}">
    <div style="color: red">
        <c:forEach var="error" items="${requestScope.errors}">
            <span>${error.message}</span>
            <br>
        </c:forEach>
    </div>


</c:if>
</body>
</html>