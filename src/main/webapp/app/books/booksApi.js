(function () {
    angular.module('bookRegister')
        .service('BooksApi', BooksApi)

    function BooksApi($resource) {
        return {
            findAll: findAll,
            save: save
        };

        function findAll() {
            return $resource('api/books').query().$promise;
        }

        function save(dto) {
            return $resource('api/books').save(dto).$promise;
        }
    }

   BooksApi.$inject = ['$resource'];
})();
