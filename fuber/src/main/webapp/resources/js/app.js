angular.module('myApp', [ 'ui.router' ])

.controller('CabController', function($scope, $http, $state, $stateParams) {

	if ($state.is('dashboard')) {
		$http.get('/fuber/getallcabs').then(function(response) {
			$scope.cabs = response.data;
		});
	}
	
	if ($state.is('travellog')) {
		$http.get('/fuber/travellog').then(function(response) {
			$scope.travelLog = response.data;
		});
	}

	if ($state.is('bookcab')) {
		$http.get('/fuber/cab').then(function(response) {
			$scope.user = response.data;
		});
	}

	if ($state.is('ride')) {
		$http.post('/fuber/cab', $stateParams.user).then(function(response) {
			$scope.cab = response.data;
			if($scope.cab == '') {
				$state.go('dashboard');
				alert("We're Sorry! There are no cabs available at the moment!");
			}
		});
	}

	$scope.bookcab = function() {
		$http.post('/fuber/cab', $scope.user).then(function(response) {
			$scope.cab = response.data;
			if($scope.cab == '') {
				$state.go('dashboard');
				alert("We're Sorry! There are no cabs available at the moment!");
			} else {
				$state.go('ride', {user:$scope.user});
			}
		});
		
	};
	
	$scope.endride = function() {
		$scope.user.location = $stateParams.user.location;
		$scope.user.colorPreference = $stateParams.user.colorPreference;
		$http.post('/fuber/endride', $scope.user).then(function(response) {
			$scope.rideEnded = true;
			$scope.user = response.data;
		});
	};

}).config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/');

	$stateProvider

	.state('dashboard', {
		url : '/',
		templateUrl : 'views/dashboard.tpl.html',
		controller : 'CabController'
	}).state('bookcab', {
		url : '/book',
		templateUrl : 'views/book-cab.tpl.html',
		controller : 'CabController'
	}).state('travellog', {
		url : '/travellog',
		templateUrl : 'views/travellog.tpl.html',
		controller : 'CabController'
	}).state('ride', {
		url : '/ride',
		params: {
			user: null
		},
		templateUrl : 'views/ride-estimate.tpl.html',
		controller : 'CabController'
	});

});