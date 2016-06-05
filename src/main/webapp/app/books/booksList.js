(function () {
    angular.module('bookRegister')
        .directive('booksList', function () {
            return {
                restrict: 'E',
                scope: {},
                templateUrl: 'app/books/booksList.html',
                controllerAs: 'ctrl',
                bindToController: true,
                controller: ['BooksApi', function (BooksApi) {
                    var ctrl = this;

                    ctrl.refresh = refresh;

                    refresh();

                    function refresh() {
                        BooksApi.findAll().then(function (data) {
                            ctrl.books = getBooksFromResource(data);
                        });
                    }

                    function getBooksFromResource(data) {
                        var books = [];
                        for (var i = 0; i < data.length; i++) {
                            books.push(data[i]);
                        }
                        return books;
                    }
                }]
            }
        });
})();
