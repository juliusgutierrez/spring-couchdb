'use strict';

var User = {
    username : "admin",
    password : ''
}

var springCouchController = angular.module('springCouchControllers', []);

/*springCouchController.controller('phoneListCtrl', function($scope, $http) {
    $http.get('/get-all-phone').success(function(data) {
        $scope.details = data;
    });
    $scope.orderProp = "age";
});*/

springCouchController.controller('phoneListCtrl', ['$scope', 'Phone',
    function($scope, Phone) {
        $scope.details = Phone.query();
        $scope.orderProp = 'age';
    }
]);



springCouchController.controller('phoneDetailsCtrl', ['$scope', '$routeParams'],
    function($scope, $routeParams) {
        $scope.phoneId = $routeParams.phoneId;

});