<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--  ${pageContext.request.contextPath} --%>
<form action="${pageContext.request.contextPath}/e/t1" method="post">
    <input type="text" name="name"/>
    <input type="submit">
</form>

</body>
</html>
