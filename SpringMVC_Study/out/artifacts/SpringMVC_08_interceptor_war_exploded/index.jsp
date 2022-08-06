<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  实现目标：不登陆不能进入首页  --%>
    <h1><a href="${pageContext.request.contextPath}/user/goLogin">登录</a></h1>
    <h1><a href="${pageContext.request.contextPath}/user/goMain">首页</a></h1>
  </body>

</html>
