(function () {
    angular.module('bookRegister')
        .directive('authorsEdit', function () {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'app/authors/authorsEdit.html',
                controllerAs: 'ctrl',
                bindToController: true,
                controller: ['AuthorsApi', function (AuthorsApi) {
                    var ctrl = this;

                    ctrl.submit = submit;

                    function submit() {
                        AuthorsApi.save({
                            firstName: ctrl.firstName,
                            surname: ctrl.surname,
                            birthDate: getBirthDate(),
                            deathDate: getDeathDate()
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
                        console.log(str.length);
                        return str.length === 1 ? ('0' + str) : str;
                    }
                }]
            }
        });
})();
