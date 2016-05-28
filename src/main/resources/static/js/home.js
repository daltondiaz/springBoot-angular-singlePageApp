var home = angular.module('homeApp', [ 'ngRoute' ]);

home.config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'home.html',
		controller : 'home'
	}).when('/login', {
		templateUrl : 'login.html',
		controller : 'navigation'
	}).when('/signup', {
		templateUrl : '/views/users.html',
		controller : 'SignUpController',
	}).otherwise('/');

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  });

  home.controller('home', function($scope, $http) {
    $http.get('/resource/').success(function(data) {
      $scope.greeting = data;
    })
  });
  
home.controller('navigation',  function($rootScope, $scope, $http, $location) {

  var authenticate = function(credentials, callback) {

    var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
    } : {};

    $http.get('user', {headers : headers}).success(function(data) {
      if (data.name) {
        $rootScope.authenticated = true;
      } else {
        $rootScope.authenticated = false;
      }
      callback && callback();
    }).error(function() {
      $rootScope.authenticated = false;
      callback && callback();
    });

  }

  authenticate();
  $scope.credentials = {};
  $scope.login = function() {
      authenticate($scope.credentials, function() {
        if ($rootScope.authenticated) {
          $location.path("/");
          $scope.error = false;
        } else {
          $location.path("/login");
          $scope.error = true;
        }
      });
  };
  
  $scope.logout = function() {
	  $http.post('logout', {}).success(function() {
	    $rootScope.authenticated = false;
	    $location.path("/");
	  }).error(function(data) {
	    $rootScope.authenticated = false;
	  });
	}

});
  
home.controller('SignUpController', function($scope, $http){
	$scope.title = "New User";
	$scope.submitForm = submitForm;
	function submitForm(person){
		console.log('person',$scope.person);
		var sendPerson = {
				method: 'GET',
				url: '/user/new/',
				data: $scope.person,
				
		}
		$http(sendPerson).success(function(data) {
		  $scope.success = "Welcome to our project";
		}).error(function(data) {
		  console.log('error',data);
		});
	}
});