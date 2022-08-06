<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>
    <%--  BootStrap美化界面:  --%>
    <%--     新 Bootstrap 核心 CSS 文件 --%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<%--
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
--%>

</head>
<body>

    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>书籍列表——显示所有书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示所有书籍</a>
            </div>

            <%-- 按照id查询书籍 ： --%>
            <div class="col-md-4 column">
                <form action="${pageContext.request.contextPath}/book/queryBookById" method="post" class="form-inline">
                    <span style="color: red">${error}</span>
                    <input type="text" class="form-control" name="queryBookId" placeholder="请输入要查询的书籍的编号！" required>
                    <input type="submit" class="btn btn-primary" value="查询">
                </form>
            </div>

            <%-- 按照名字模糊查询书籍： --%>
            <div class="col-md-4 column">
                <form action="${pageContext.request.contextPath}/book/queryBook" method="post" class="form-inline">
                    <input type="text" class="form-control" name="queryBookName" placeholder="请输入要查询的书籍的名称！" required>
                    <input type="submit" class="btn btn-primary" value="查询">
                </form>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <td>书籍编号</td>
                            <td>书籍名称</td>
                            <td>书籍数量</td>
                            <td>书籍详情</td>
                            <td>操作</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${list}">
                            <tr>
                                <td>${book.bookID}</td>
                                <td>${book.bookName}</td>
                                <td>${book.bookCounts}</td>
                                <td>${book.detail}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/book/toUpdatePage?id=${book.bookID}">修改</a>
                                    &nbsp; | &nbsp;
                                    <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

</body>
</html>
