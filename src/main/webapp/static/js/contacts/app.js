/**
 * Created by usegutierrez on 12/15/14.
 */

var myContact = angular.module('myContactApp', ['ui.router', 'contactsControllers']);

myContact.config(["$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.when("/", "/contacts");
    $urlRouterProvider.otherwise("/contacts/list");

    $stateProvider
        .state("contact", {
            url: "/contacts",
            templateUrl: "/contacts",
            controller: 'contactsList',
            onEnter: function(){
                console.log("enter contacts");
            }
        })
        .state("contact.list", {
            url: "/list",
            templateUrl: "/contact-list",
            onEnter: function() {
                console.log("enter contact-list");
            }
        })
        .state("contact.details", {
            url: "/:id",
            templateUrl: "/contact-details",
            controller: 'contactDetails',
            onEnter: function() {
                console.log("enter contact-details");
            }
        })
}]);
