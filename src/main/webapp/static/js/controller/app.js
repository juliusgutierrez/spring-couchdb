/**
 * Created by usegutierrez on 12/12/14.
 */

angular.module('springCouchApp', ['ui.router', 'springCouchControllers'])

.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('start', {
            url: "/url",
            templateUrl : "welcome.jsp"
        })
})

