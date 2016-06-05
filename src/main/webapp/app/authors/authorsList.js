(function () {
    angular.module('homeLibrary')
        .directive('authorsList', function () {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'app/authors/authorsList.html',
                controllerAs: 'ctrl',
                bindToController: true,
                controller: ['AuthorsApi', function (AuthorsApi) {
                    var ctrl = this;

                    ctrl.refresh = refresh;

                    refresh();

                    function refresh() {
                        AuthorsApi.findAll().then(function (data) {
                            ctrl.authors = getAuthorsFromResource(data);
                        });
                    }

                    function getAuthorsFromResource(data) {
                        var authors = [];
                        for (var i = 0; i < data.length; i++) {
                            authors.push(data[i]);
                        }
                        return authors;
                    }
                }]
            }
        });
})();
