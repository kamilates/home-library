(function () {
    angular.module('homeLibrary')
        .directive('booksEdit', function () {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'app/books/booksEdit.html',
                controllerAs: 'ctrl',
                bindToController: true,
                controller: ['BooksApi', function (BooksApi) {
                    var ctrl = this;

                    ctrl.submit = submit;

                    function submit() {
                        BooksApi.save({
                            title: ctrl.title,
                            originalTitle: ctrl.originalTitle,

                        });
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
