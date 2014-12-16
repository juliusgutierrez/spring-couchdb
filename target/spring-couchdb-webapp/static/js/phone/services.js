/**
 * Created by usegutierrez on 12/15/14.
 */
var phoneService = angular.module('phoneServices', ['ngResource']);

phoneService.factory('Phone', ['$resource', function($resource) {
        return $resource('/get-all-phone', {}, {
           query: {method:'GET', isArray: true}
        });
    }
]);
