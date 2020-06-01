<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    request跳转成功<br>
    ${requestScope.msg}<br>
    ${sessionScope.msg}<br>
    ${user.username}
    ${user.age}<br><br>

    response跳转成功<br>
    ${user.username}
    ${user.age}

    <% System.out.println("success.jsp执行了"); %>
</body>
</html>
