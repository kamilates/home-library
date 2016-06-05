(function () {
    angular.module('homeLibrary')
        .directive('authors', function () {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'app/authors/authors.html',
                controllerAs: 'ctrl',
                bindToController: true,
                controller: [function () {
                }]
            }
        });
})();
