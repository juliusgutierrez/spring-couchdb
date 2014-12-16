/**
 * Created by usegutierrez on 12/15/14.
 */
'use-strict';


var contactsControllers = angular.module("contactsControllers",[]);

contactsControllers
    .controller('contactsList', function($scope) {
        $scope.contacts = [{ id:0, name: "Alice" }, { id:1, name: "Bob" }];
    })
    .controller('contactDetails', function($scope, $stateParams) {
        $scope.person = $scope.contacts[$stateParams.id];
    });


