<%--
  Created by IntelliJ IDEA.
  User: usegutierrez
  Date: 12/11/14
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="include.jsp"%>

<html lang="en" ng-app="springCouchApp" ng-controller="phoneListCtrl"> <!-- this is the module named as springCouchApp-->
<head>

    <link href="${contextPath}/static/css/app.css" rel="stylesheet"/>
    <link href="${contextPath}/static/css/bootstrap.css" rel="stylesheet"/>

    <script type="text/javascript" src="${contextPath}/static/js/angular/angular.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/angular/angular-ui.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/angular/angular-ui-router.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/controller/app.js"></script>
    <script type="text/javascript" src="${contextPath}/static/js/controller/controller.js"></script>

    <title ng-bind-template="Google Phone Gallery: {{query}}">Google Phone Gallery</title>
</head>
<body> <!-- this is the controller named listCtrl -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <!-- Side bar content -->
                Search: <input ng-model="query"> <br/>
                Sort By:
                    <select ng-model="orderProp">
                        <option value = "name">Alphabetical</option>
                        <option value = "age"> Newest</option>
                        <option value = "-age"> Oldest</option>
                    </select>
            </div>
            <div class="col-md-10">
                <!-- body content -->
                <ul class="phones">
                    <li ng-repeat="detail in details | filter:query | orderBy:orderProp" class="thumbnail"> <!-- a loop in details object: details is an array -->
                        <a href="#/phones/{{detail.id}}" class="thumb"><img ng-src="static/{{detail.imageUrl}}"></a>
                        <span>{{detail.name}}</span>
                        <p>{{detail.snippet}}</p>
                    </li>
                </ul>

            </div>
        </div>
    </div>
    <%--<pre>{{details | filter:query |orderBy:orderProp|json}}</pre>--%>

    <div ng-controller="DemoController">
        <div ui-view></div>
    </div>
</body>
</html>



