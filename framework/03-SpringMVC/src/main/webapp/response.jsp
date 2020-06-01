<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"account/textAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"abc","age":22}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data.username)
                        alert(data.age)
                    }
                })
            })
        })
    </script>
</head>
<body>
    <a href="account/rtValueString">返回字符串</a><br><br>
    <a href="account/rtVoidForward">返回void,使用请求转发</a><br><br>
    <a href="account/rtSendRedirect">返回void,使用重定向</a><br><br>
    <a href="account/response">返回void,不跳转,直接响应</a><br><br>
    <a href="account/rtModelAndView">返回ModelAndView</a><br><br>
    <a href="account/rtForward">关键字转发</a><br><br>
    <a href="account/rtRedirect">关键字重定向</a><br><br>
    <button id="btn">发送ajax请求</button>

</body>
</html>

<%--
http://localhost:8080/response.jsp
--%>