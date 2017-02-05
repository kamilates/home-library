(function () {
    angular.module('homeLibrary')
        .service('AuthorsStateService', AuthorsStateService)

    function AuthorsStateService($resource) {
        var state;

        return {
            setState: setState,
            getState: getState,
            isDirty: isDirty
        };

        function setState(stateName) {
            state = stateName;
        }

        function getState() {
            return state;
        }

        function isDirty() {
            return state === 'DIRTY';
        }
    }

    AuthorsStateService.$inject = [];
})();
