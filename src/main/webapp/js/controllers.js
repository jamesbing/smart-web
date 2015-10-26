angular.module('starter.controllers', [])

.controller('workCtrl',['$scope','service','$location', function($scope,service,$location) {
        $scope.sers =service.all()
        $scope.host =$location.host();
    }])
.controller('servicesCtrl',['$scope','$routeParams','service','sendOrder','$http', function($scope,$routeParams,service,sendOrder) {
        var id = $routeParams.id;
        $scope.ser =service.get(id);
        $scope.cantact={};
        $scope.ph=/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
        $scope.submit=function(){
            sendOrder.send($scope.cantact)
        }
    }])
.controller('storyCtrl', ['$scope', function($scope) {}])
.controller('contactCtrl', ['$scope','sendOrder', function($scope,sendOrder) {
        $scope.sendOrder=function(){
            sendOrder.send();
        }
    }])
.controller('homeCtrl', ['$scope','$location','$anchorScroll', function($scope,$location,$anchorScroll) {
       $scope.toTop =function(){
           $location.hash('header')
       }
    }])
.controller('singleCtrl', ['$scope', function($scope) {}])


//['$scope','$location','$service',function($scope,$location,$service) {
//console.log($service)
//}]
//.controller('ChatsCtrl', function($scope, Chats) {
//  // With the new view caching in Ionic, Controllers are only called
//  // when they are recreated or on app start, instead of every page change.
//  // To listen for when this page is active (for example, to refresh data),
//  // listen for the $ionicView.enter event:
//  //
//  //$scope.$on('$ionicView.enter', function(e) {
//  //});
//
//  $scope.chats = Chats.all();
//  $scope.remove = function(chat) {
//    Chats.remove(chat);
//  };
//})
//.controller('workCtrl',function($scope,$http){
//        $scope.service= function sericeList($scope,$http){
//            $http.get("http://localhost:9200/service/xm/",{})
//                .success(function(date){
//                $scope.date=date;
//            });
//        }
//    })
//
//.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
//  $scope.chat = Chats.get($stateParams.chatId);
//})
//
//.controller('AccountCtrl', function($scope) {
//  $scope.settings = {
//    enableFriends: true
//  };
//});
