angular.module('search', [])
    .controller('searchController', function ($scope, $http) {
        $scope.searchString = "";
        $scope.search = function () {
            $http({
                url: 'http://localhost:8080/api/search',
                method: "GET",
                params: {
                    query: $scope.searchString
                }
            }).then(function (response) {
                $scope.data = response.data;
            });
        }
    });