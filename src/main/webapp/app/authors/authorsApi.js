(function () {
    angular.module('bookRegister')
        .service('AuthorsApi', AuthorsApi)

    function AuthorsApi($resource) {
        return {
            findAll: findAll,
            save: save
        };

        function findAll() {
            return $resource('api/authors').query().$promise;
        }

        function save(dto) {
            return $resource('api/authors').save(dto).$promise;
        }
    }

    AuthorsApi.$inject = ['$resource'];
})();
