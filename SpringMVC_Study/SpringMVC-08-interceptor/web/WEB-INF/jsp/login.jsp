
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
    <h1>登录</h1>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        用户名：<input type="text" name="username"/>
        密码：<input type="password" name="password"/>
        <input type="submit" value="登录" />
    </form>
</body>
</html>
