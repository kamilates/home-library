(function () {
    angular.module('homeLibrary')
        .service('AuthorsApi', AuthorsApi)

    function AuthorsApi($resource) {
        return {
            findAll: findAll,
            save: save,
            load: load
        };

        function findAll() {
            return $resource('api/authors').query().$promise;
        }

        function save(dto) {
            return $resource('api/authors').save(dto).$promise;
        }

        function load(id) {
            return $resource('api/authors/:id').get({id: id}).$promise;
        }
    }

    AuthorsApi.$inject = ['$resource'];
})();
