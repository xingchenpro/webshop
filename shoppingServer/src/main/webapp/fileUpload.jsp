<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2019/1/11
  Time: 10:58
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileUpload</title>
</head>
<body>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" value="请选择上传的文件">
    <input type="submit" value="提交">
</form>
</body>
</html>
