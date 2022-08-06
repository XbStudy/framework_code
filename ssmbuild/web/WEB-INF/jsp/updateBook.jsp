<%--
  Created by IntelliJ IDEA.
  User: DearLin
  Date: 2022/3/14
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <%--  BootStrap美化界面:  --%>
    <%--     新 Bootstrap 核心 CSS 文件 --%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>修改书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
            <%-- 使用隐藏域传递id：--%>
            <input type="hidden" name="bookID" value="${book.bookID}">
            <div class="form-group">
                <label>书籍名称：</label>
                <input type="text" class="form-control" name="bookName" value="${book.bookName}" required>
            </div>
            <div class="form-group">
                <label>书籍数量</label>
                <input type="text" class="form-control" name="bookCounts" value="${book.bookCounts}" required>
            </div>
            <div class="form-group">
                <label>书籍描述：</label>
                <input type="text" class="form-control" name="detail" value="${book.detail}" required>
            </div>
            <button type="submit" class="btn btn-default">修改</button>
        </form>
    </div>


</body>
</html>
