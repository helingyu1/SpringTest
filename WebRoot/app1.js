﻿var routeApp = angular.module('routeApp', [ "ngCookies", "ui.bootstrap",
		"ngRoute", "toastr" ]);

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
	}).when('/', {
		templateUrl : 'agl_start.html',
		controller : 'ModalController'
	}).otherwise({
	// redirectTo : '/'
	});
} ]);

// logonController
routeApp.controller('LoginController', function($scope, $http, $location,
		$cookieStore, BlogData) {
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
				// BlogData.result = data.message;
				// alert(BlogData.result);
				// $cookieStore.put("username", data.message);
				$http({
					method : 'POST',
					url : 'timeline/showFocusTL.do',
					data : {
						u_name : data.message
					},
				}).success(function(data) {
					$cookieStore.put("blogs", data);
				});

				$location.path('/homepage');
			} else {
				$scope.errorMessage = data.message;
			}
		});
	};
});
// RegisterController
routeApp.controller('RegisterController', function($scope, $http, $location,
		$cookieStore) {
	$scope.formData = {};
	$scope.processForm = function() {
		$http({
			method : 'POST',
			url : 'user/register.do',
			data : {
				u_name : $scope.formData.name,
				u_pwd : $scope.formData.pwd,
				u_nick : $scope.formData.nickname
			},
		}).success(function(data) {
			if (data.state) {
				$cookieStore.put("username", data.message);
				$location.path('/homepage');
			}
		});
	};
});
// HomePageController
routeApp.controller('HomePageCtl', function($scope, $cookieStore, $http,toastr) {
	$scope.username = $cookieStore.get("username");
	$scope.data = "";
	$scope.blogs = $cookieStore.get("blogs");
	$scope.processBlog = function() {
		$http({
			method : 'POST',
			url : 'blog/publish.do',
			data : {
				b_uname : $scope.username,
				b_content : $scope.data,
				b_isTurn : 0,
				b_time : 0,
				b_turn : 0,
				b_keep : 0,
				b_comment : 0
			},
		}).success(function(data) {
			if (data.state) {
				toastr.info("发布成功！");
				$scope.data = "";
			}
		});
	};
	$scope.left = function() {
		return 140 - $scope.data.length;
	};
});
routeApp.controller('ModalController', function($scope, $uibModal, $location) {
	$scope.addModal = function() {
		var logonModal = $uibModal.open({
			templateUrl : 'myModelContent.html',
			controller : 'ModalInstanceController',
			size : 'lg'

		});
	};
	$scope.register = function() {
		alert("注册");
		$location.path('/register');

	};
});
routeApp.controller('ModalInstanceController', function($scope,
		$uibModalInstance, $http, $cookieStore, $location,toastr) {
	$scope.formData = {};

	$scope.ok = function() {
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
				$cookieStore.put("username", data.message);
				$http({
					method : 'POST',
					url : 'timeline/showFocusTL.do',
					data : {
						u_name : data.message
					},
				}).success(function(data) {
					$cookieStore.put("blogs", data);
					toastr.success("恭喜您，登录成功！")
					$location.path('/homepage');
				});
				// $location.path('/homepage');
				$uibModalInstance.dismiss('cancel');
			} else {
				$scope.errorMessage = data.message;
			}
		});
	};

	$scope.cancel = function() {
		$uibModalInstance.dismiss('cancel');
	};

});
routeApp.controller('CarouselCtl', function($scope) {
	$scope.images = [ {
		"id" : 1,
		"name" : "梅西",
		"path" : "resources/images/messi.jpg"
	}, {
		"id" : 2,
		"name" : "内马尔",
		"path" : "resources/images/neymar.jpg"
	}, {
		"id" : 3,
		"name" : "苏亚雷斯",
		"path" : "resources/images/suarez.jpg"
	} ];
	$scope.myInterval = 3000;
});
routeApp.config(function(toastrConfig) {
	angular.extend(toastrConfig, {
		autoDismiss : false,
		containerId : 'toast-container',
		maxOpened : 0,
		newestOnTop : true,
		positionClass : 'toast-top-center',
		preventDuplicates : false,
		preventOpenDuplicates : false,
		target : 'body'
	});
});
