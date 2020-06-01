<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="user/requestMapping?username=abc">RequestMapping注解</a><br><br>

    <form method="post" action="user/javaBean1">
        姓名:<input type="text" name="username" value="zhangsan">
        年龄:<input type="text" name="age" value="23">
        <input type="submit" value="请求参数封装1">
    </form>

    <form method="post" action="user/javaBean2">
        姓名:<input type="text" name="username" value="zhangsan">
        年龄:<input type="text" name="age" value="23">
        金额:<input type="text" name="account.money" value="1000">
        <input type="submit" value="请求参数封装2">
    </form>

    <form method="post" action="user/javaBean3">
        姓名:<input type="text" name="username" value="zhangsan">
        年龄:<input type="text" name="age" value="23">

        金额:<input type="text" name="accountList[0].money" value="1000">
        金额:<input type="text" name="accountList[1].money" value="1000">
        <input type="submit" value="请求参数封装list">
    </form>

    <form method="post" action="user/javaBean4">
        姓名:<input type="text" name="username" value="zhangsan">
        年龄:<input type="text" name="age" value="23">

        金额:<input type="text" name="accountMap['money0'].money" value="1000">
        金额:<input type="text" name="accountMap['money1'].money" value="1000">
        <input type="submit" value="请求参数封装map">
    </form>

    <a href="user/servletApi">获取servlet原生Api</a><br><br>

    <a href="user/requestParam?name=hehe">RequestParam注解</a><br><br>

    <form method="post" action="user/requestBody">
        姓名:<input type="text" name="username" value="zhangsan">
        年龄:<input type="text" name="age" value="23">
        <input type="submit" value="requestBody注解">
    </form>

    <a href="user/pathVariable/10">PathVariable注解</a><br><br>

    <a href="user/requestHeader">requestHeader注解</a><br><br>

    <a href="user/cookieValue">cookieValue注解</a><br><br>

    <form action="/user/modelAttribute" method="post">
        <input type="text" name="username" value="abc">
        <input type="submit" value="ModelAttribute注解">
    </form>

    <a href="user/sessionAttribute">SessionAttribute注解</a><br><br>

    <%--
    http://localhost:8080/request.jsp
     --%>

</body>
</html>
