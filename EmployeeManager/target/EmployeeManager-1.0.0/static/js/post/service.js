'use strict';

App.factory('PostService', ['$http', '$q', function ($http, $q) {

        self.headers = {};
        self.headers["Content-Type"] = 'application/json';

        return {
            fetchAllPosts: function () {
                return $http.get('/EmployeeManager/posts')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching posts');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            createPost: function (post) {
                return $http.post('/EmployeeManager/posts/item',
                        JSON.stringify(post))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating post');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            updatePost: function (post) {
                return $http.put('/EmployeeManager/posts/item',
                        JSON.stringify(post))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while updating post');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            deletePost: function (post) {
                return $http({method: 'DELETE',
                    url: '/EmployeeManager/posts/item/',
                    data: JSON.stringify(post),
                    headers: self.headers})
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while deleting post');
                                    return $q.reject(errResponse);
                                }
                        );
            }

        };
    }]);


