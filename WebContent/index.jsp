<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<head>
    <title>欢迎来到tinyshop8系统!</title>
    <script type="text/javascript" src="http://localhost/jsLib2017/jquery/v3.1.0.js"></script>
    <script type="text/javascript" src="http://localhost/bootstrap3/js/bootstrap.js"></script>
    <link rel="stylesheet" href="http://localhost/bootstrap3/css/bootstrap.css">
    <jsp:include page="WEB-INF/js/indexJS.jsp"></jsp:include>
</head>

<body>
<div class="container" style="width: 60%;">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="form-group">
                <label for="label1">Email address</label>
                <input type="text" class="form-control" id="username"/>
            </div>
            <div class="form-group">
                <label for="label2">Password</label>
                <input type="password" class="form-control" id="password"/>
            </div>
            <button type="button" class="btn btn-default" id="doLogin">登录</button>
            &nbsp;
            <%--<button type="button" class="btn btn-default" id="doRegister">注册</button>--%>
        </div>
    </div>
</div>
</body>