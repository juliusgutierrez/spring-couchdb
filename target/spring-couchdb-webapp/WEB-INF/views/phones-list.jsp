<%--
  Created by IntelliJ IDEA.
  User: usegutierrez
  Date: 12/11/14
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="include.jsp"%>

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
                <li ng-repeat="detail in details | filter:query | orderBy:orderProp" class="thumbnail phone-listing">
                    <!-- a loop in details object: details is an array -->
                    <a href="#/phones/{{detail.id}}" class="thumb"><img ng-src="static/{{detail.imageUrl}}"></a>
                    <span>{{detail.name}}</span>
                    <p>{{detail.snippet}}</p>
                </li>
            </ul>

        </div>
    </div>
</div>


