<%--
  Created by IntelliJ IDEA.
  User: usegutierrez
  Date: 12/15/14
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>

<html ng-app="myContactApp">
<head>
    <title>Google Phone Gallery</title>

    <link href="${contextPath}/static/css/app.css" rel="stylesheet"/>
    <link href="${contextPath}/static/css/animation.css" rel="stylesheet"/>
    <link href="${contextPath}/static/css/bootstrap.css" rel="stylesheet"/>

    <script type="text/javascript" src="${contextPath}/static/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/angular/angular133.min.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/angular/angular-ui-router.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/angular/angular-resource.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/angular/angular-animate.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/contacts/app.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/contacts/services.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/contacts/controllers.js"></script>

</head>
<body>

    <!-- NAVIGATION -->
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" ui-sref="#">AngularUI Router</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a ui-sref="home">Home</a></li>
            <li><a ui-sref="about">About</a></li>
        </ul>
    </nav>

    <div ui-view></div>
</body>
</html>