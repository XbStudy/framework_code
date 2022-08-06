<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

<%-- 文件上传的表单：必须设置属性值  enctype="multipart/form-data" method="post"
      这种情况下浏览器会把用户选择的文件以二进制数据发送给服务器--%>
  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="提交"/>
  </form>

  <a href="${pageContext.request.contextPath}/static/1.png" >下载图片</a>

  </body>
</html>
