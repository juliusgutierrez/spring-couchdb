<%--
  Created by IntelliJ IDEA.
  User: usegutierrez
  Date: 12/12/14
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="springCouchApp">
<head>
    <title>Google Phone Gallery</title>

    <link href="${contextPath}/../static/css/app.css" rel="stylesheet"/>
    <link href="${contextPath}/../static/css/animation.css" rel="stylesheet"/>
    <link href="${contextPath}/../static/css/bootstrap.css" rel="stylesheet"/>

    <script type="text/javascript" src="${contextPath}/../static/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="${contextPath}/../static/js/angular/angular133.min.js"></script>
    <script type="text/javascript" src="${contextPath}/../static/js/angular/angular-route.js"></script>
    <script type="text/javascript" src="${contextPath}/../static/js/angular/angular-resource.js"></script>
    <script type="text/javascript" src="${contextPath}/../static/js/angular/angular-animate.js"></script>
    <script type="text/javascript" src="${contextPath}/../static/js/phone/app.js"></script>
    <script type="text/javascript" src="${contextPath}/../static/js/phone/services.js"></script>
    <script type="text/javascript" src="${contextPath}/../static/js/phone/controller.js"></script>
    <script type="text/javascript" src="${contextPath}/../static/js/phone/animation.js"></script>
</head>
<body>
    <%--<jsp:include page="phones-list.jsp"/>--%>
    <div ng-view></div>
</body>
</html>

