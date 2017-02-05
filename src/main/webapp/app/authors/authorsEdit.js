(function () {
    angular.module('homeLibrary')
        .directive('authorsEdit', function () {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'app/authors/authorsEdit.html',
                controllerAs: 'ctrl',
                bindToController: true,
                controller: authorsEditController
            }

            function authorsEditController($rootScope, AuthorsApi, AuthorsStateService, $scope) {
                var ctrl = this;

                ctrl.submit = submit;

                $scope.$watchGroup([
                    'ctrl.firstName',
                    'ctrl.surname',
                    'ctrl.birthYear',
                    'ctrl.birthMonth',
                    'ctrl.birthDay',
                    'ctrl.deathYear',
                    'ctrl.deathMonth',
                    'ctrl.deathDay'
                ], function (newValue, oldValue) {
                    var isEmpty = true;
                    for (var i = 0; i < newValue.length; i++) {
                        if (newValue[i] !== undefined && newValue[i] !== '') {
                            isEmpty = false;
                            break;
                        }
                    }

                    AuthorsStateService.setState(isEmpty ? 'PRISTINE' : 'DIRTY');
                });

                $rootScope.$on('loadAuthorForEdit', function (event, params) {
                    AuthorsApi.load(params.id).then(function (result) {
                        var birthDateParts = result.birthDate.split('-');
                        var deathDateParts = result.deathDate.split('-');
                        ctrl.id = result.id;
                        ctrl.firstName = result.firstName;
                        ctrl.surname = result.surname;
                        ctrl.birthYear = parseInt(birthDateParts[0], 10);
                        ctrl.birthMonth = parseInt(birthDateParts[1], 10);
                        ctrl.birthDay = parseInt(birthDateParts[2], 10);
                        ctrl.deathYear = parseInt(deathDateParts[0], 10);
                        ctrl.deathMonth = parseInt(deathDateParts[1], 10);
                        ctrl.deathDay = parseInt(deathDateParts[2], 10);
                    });
                });

                function submit() {
                    AuthorsApi.save({
                        id: ctrl.id,
                        firstName: ctrl.firstName,
                        surname: ctrl.surname,
                        birthDate: getBirthDate(),
                        deathDate: getDeathDate()
                    }).then(function () {
                        ctrl.id = undefined;
                        ctrl.firstName = undefined;
                        ctrl.surname = undefined;
                        ctrl.birthYear = undefined;
                        ctrl.birthMonth = undefined;
                        ctrl.birthDay = undefined;
                        ctrl.deathYear = undefined;
                        ctrl.deathMonth = undefined;
                        ctrl.deathDay = undefined;
                    });
                }

                function getBirthDate() {
                    return ctrl.birthYear + '-' + addPadding(ctrl.birthMonth) + '-' + addPadding(ctrl.birthDay);
                }

                function getDeathDate() {
                    return ctrl.deathYear + '-' + addPadding(ctrl.deathMonth) + '-' + addPadding(ctrl.deathDay);
                }

                function addPadding(str) {
                    str = '' + str;
                    if (typeof str === 'undefined') {
                        return '';
                    }
                    return str.length === 1 ? ('0' + str) : str;
                }
            }

            authorsEditController.$inject = ['$rootScope', 'AuthorsApi', 'AuthorsStateService', '$scope'];
        });
})();
