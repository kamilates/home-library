(function () {
    angular.module('homeLibrary')
        .directive('books', function () {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'app/books/books.html',
                controllerAs: 'ctrl',
                bindToController: true,
                controller: [function () {
                }]
            }
        });
})();
