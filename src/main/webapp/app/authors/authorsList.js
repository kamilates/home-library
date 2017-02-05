(function () {
    angular.module('homeLibrary')
        .directive('authorsList', function () {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'app/authors/authorsList.html',
                controllerAs: 'ctrl',
                bindToController: true,
                controller: authorsListController
            }

            function authorsListController($rootScope, AuthorsApi, AuthorsStateService) {
                var ctrl = this;
                var isErrorPresent = false;
                var errorMessage = '';

                ctrl.refresh = refresh;
                ctrl.edit = edit;
                ctrl.hasError = hasError;
                ctrl.getError = getError;

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

                function edit(id) {
                    if (AuthorsStateService.isDirty()) {
                        isErrorPresent = true;
                        errorMessage = 'Something is already being edited. Save or discard changes first.';
                        $(".author-edit-modal").modal();
                    } else {
                        $rootScope.$broadcast('loadAuthorForEdit', {
                            id: id
                        });
                    }
                }

                function hasError() {
                    return isErrorPresent;
                }

                function getError() {
                    return errorMessage;
            }

            authorsListController.$inject = ['$rootScope', 'AuthorsApi', 'AuthorsStateService'];
          }
        });
})();
