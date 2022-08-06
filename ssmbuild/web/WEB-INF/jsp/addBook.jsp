<%--
  Created by IntelliJ IDEA.
  User: DearLin
  Date: 2022/3/14
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
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
                        <small>新增书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/book/addBook" method="post">
            <div class="form-group">
                <label>书籍名称：</label>
                <input type="text" class="form-control" name="bookName" required>
            </div>
            <div class="form-group">
                <label>书籍数量</label>
                <input type="text" class="form-control" name="bookCounts" required>
            </div>
            <div class="form-group">
                <label>书籍描述：</label>
                <input type="text" class="form-control" name="detail" required>
            </div>
            <button type="submit" class="btn btn-default">添加</button>
        </form>
    </div>




</body>
</html>
