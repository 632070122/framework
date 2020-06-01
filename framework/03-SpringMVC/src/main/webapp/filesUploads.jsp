<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>传统文件上传</h3>
    <form action="upload/traditionUpload" method="post" enctype="multipart/form-data">
        <input type="file" name="upload">
        <input type="submit" value="上传">
    </form>

    <h3>SpringMVC文件上传</h3>
    <form action="upload/springMVCUpload" method="post" enctype="multipart/form-data">
        <input type="file" name="upload">
        <input type="submit" value="上传">
    </form>

    <h3>跨服务器文件上传</h3>
    <form action="upload/servletFileUpload" method="post" enctype="multipart/form-data">
        <input type="file" name="upload">
        <input type="submit" value="上传">
    </form>
</body>
</html>
