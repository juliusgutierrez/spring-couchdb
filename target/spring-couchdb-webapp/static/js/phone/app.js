/**
 * Created by usegutierrez on 12/12/14.
 */

//angular.module('springCouchApp', ['ngRoute', 'phoneAnimation', 'springCouchControllers', 'phoneServices']);

var phoneApp = angular.module('springCouchApp', ['ngRoute', 'springCouchControllers', 'phoneServices']);

phoneApp.config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/phones', {
                templateUrl : '/phones-list',
                controller : 'phoneListCtrl'
            })
            .when('/phones/:phoneId', {
                templateUrl : '/phone-details',
                controller : 'phoneDetailsCtrl'
            })
            .otherwise({
               redirectTo : '/phones'
            });

    }
]);


