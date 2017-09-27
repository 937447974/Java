<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
    <script type="text/javascript" src=${pageContext.request.contextPath}/js/jquery-1.11.3.min.js></script>
    <script type="text/javascript">
        function check() {
            var file = document.getElementById("file").value;
            if (file.length == 0 || file == "") {
                alert("请选择上传文件");
                return false;
            }
            return true;
        }

        function fileUpload() {
            if (check()) {
                // FormData 对象
                var form = new FormData($("#uploadForm")[0]);
                // XMLHttpRequest 对象
                var xhr = new XMLHttpRequest();
                xhr.open("post", "${pageContext.request.contextPath }/fileUpload", true);
                xhr.upload.addEventListener("progress", progressFunction, false);
                xhr.send(form);
            }
        }

        function progressFunction(evt) {
            if (evt.lengthComputable) {
                var progressBar = document.getElementById("progressBar");
                progressBar.max = evt.total;
                progressBar.value = evt.loaded;
                if (evt.loaded == evt.total) {
                    alert("上传完成100%" + evt.total);
                }
            }
        }

    </script>
</head>
<body>
<%-- post 提交
<form action="${pageContext.request.contextPath }/fileUpload" method="post" enctype="multipart/form-data"
      onsubmit="return check()">
    请选择文件：<input id="file" type="file" name="uploadfile" multiple="multiple"/><br/>
    <input type="submit" value="上传"/>
</form>
--%>
<%--ajax 提交--%>
<form id="uploadForm">
    请选择文件：<input id="file" type="file" name="uploadfile" multiple="multiple"/><br/>
    <progress id="progressBar" value="10" max="100"></progress>
    <br/>
    <input type="button" value="上传" onclick="fileUpload()"/>
</form>
</body>
</html>