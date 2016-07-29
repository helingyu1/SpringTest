var routeApp = angular.module('routeApp', ["ngCookies","ui.bootstrap","ngRoute"]);

routeApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/logon', {
		templateUrl : 'agl_logon.html',
		controller : 'LoginController'
	}).when('/register', {
		templateUrl : 'agl_register.html',
		controller : 'RegisterController'
	}).when('/homepage', {
		templateUrl : 'agl_homepage.html',
		controller : 'HomePageCtl'
	}).when('/',{
		templateUrl : 'agl_start.html',
		controller : 'ModalController'
	}).otherwise({
	// redirectTo : '/'
	});
} ]);
// logonController
routeApp.controller('LoginController', function($scope, $http, $location,$cookieStore) {
	$scope.errorMessage;
	$scope.formData = {};
	// process the form
	$scope.processForm = function() {
		$http({
			method : 'POST',
			url : 'user/logon.do',
			type : 'text',
			data : {
				u_name : $scope.formData.name,
				u_pwd : $scope.formData.pwd
			},
		}).success(function(data) {
			if (data.state) {
				$cookieStore.put("username",data.message);
				$http({
					method : 'POST',
					url : 'timeline/showFocusTL.do',
					data : {
						u_name : data.message
					},
				}).success(function(data) {
					$cookieStore.put("blogs",data);
				});
				
				//alert("成功啦~~~~~");
				$location.path('/homepage');
			} else {
				$scope.errorMessage = data.message;
			}
		});
	};
});
//RegisterController
routeApp.controller('RegisterController',function($scope,$http,$location,$cookieStore){
	$scope.formData={};
	$scope.processForm=function(){
		$http({
			method : 'POST',
			url : 'user/register.do',
			data : {
				u_name : $scope.formData.name,
				u_pwd : $scope.formData.pwd,
				u_nick: $scope.formData.nickname
			},
		}).success(function(data) {
			if(data.state){
				$cookieStore.put("username",data.message);
				$location.path('/homepage');
			}
		});
	};
});
//HomePageController
routeApp.controller('HomePageCtl', function($scope,$cookieStore,$http) {
	$scope.username = $cookieStore.get("username");
	$scope.data = "";
	$scope.blogs = $cookieStore.get("blogs");
	$scope.processBlog = function(){
		$http({
			method : 'POST',
			url : 'blog/publish.do',
			data : {
				b_uname: $scope.username,
				b_content: $scope.data,
				b_isTurn: 0,
				b_time: 0,
				b_turn: 0,
				b_keep: 0,
				b_comment: 0
			},
		}).success(function(data) {
			if(data.state){
				alert("发布成功");
				$scope.data = "";
			}
		});
	};
});
routeApp.controller('ModalController',function($scope,$modal,$location){
	$scope.addModal = function(){
		alert("aka test");
		var logonModal = $modal.open({
			templateUrl : 'myModelContent.html',
			size : 'lg'
			
		});
	};
});
routeApp.controller('ModalInstanceController',function($scope,$modalInstance){
	
	$scope.ok = function() {
	    alert("哈喽");
	  };
	
	$scope.cancel = function() {
	    $modalInstance.dismiss('cancel');
	  };
	
});
routeApp.controller('RouteListCtl', function($scope) {
});
routeApp.controller('RouteDetailCtl', function($scope, $routeParams) {
	$scope.id = $routeParams.id;
});