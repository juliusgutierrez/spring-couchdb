<%--
  Created by IntelliJ IDEA.
  User: usegutierrez
  Date: 12/15/14
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<ul>
    <li ng-repeat="person in contacts">
        <a ng-href="#/contacts/{{person.id}}">{{person.name}}</a>
    </li>
</ul>