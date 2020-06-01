<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="user/findAll">查询所有</a>

    <form action="user/saveUser" method="post">
        姓名:<input type="text" name="username">
        地址:<input type="text" name="address">
        <input type="submit" value="提交">
    </form>
</body>
</html>
