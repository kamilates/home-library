(function () {
    angular.module('homeLibrary')
        .controller('TabsController', ['$scope', function ($scope) {
            var ctrl = $scope;

            var activeTabName = 'authors';

            ctrl.tabs = [
                {
                    name: 'authors',
                    label: 'Authors'
                },
                {
                    name: 'books',
                    label: 'Books'
                }
            ];

            ctrl.isActive = function(tabName) {
                return activeTabName === tabName;
            };

            ctrl.setActive = function(newActiveTabName) {
                activeTabName = newActiveTabName;
            };
        }]);
})();
