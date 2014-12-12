var User = {
    username : "admin",
    password : ''
}

var springCouchController = angular.module('springCouchControllers', []);

springCouchController.controller('phoneListCtrl', function($scope, $http) {
    /*$scope.details = [
        {"name" : "Nexus S", "snippet" : "Fast just got faster with Nexus S.", "age":4},
        {"name" : "Motorola XOOM™ with Wi-Fi", "snippet" : "The Next, Next Generation tablet.", "age":2},
        {"name" : "Nexus 7", "snippet" : "Most likeable tablet.", "age":3}
    ];*/

    $http.get('/get-all-phone').success(function(data) {
        $scope.details = data;
    });

    $scope.name = "World"; // <--- this is a new object

    $scope.user = User.username;

    $scope.orderProp = "age";
});



/*springCouchController.controller('DemoController', ['$scope', '$routeParams'],
    function($scope, $routeParams) {
        $scope.phoneId = $routeParams.phoneId;
});*/


