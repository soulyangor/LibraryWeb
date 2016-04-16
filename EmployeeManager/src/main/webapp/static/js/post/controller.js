'use strict';

App.controller('PostController', ['$scope', 'PostService',
    function ($scope, PostService) {
        var self = this;
        self.post = {id: null, name: ''};
        self.currentPost = {id: null, name: ''};
        self.posts = [];

        self.fetchAllPosts = function () {
            PostService.fetchAllPosts()
                    .then(
                            function (d) {
                                self.posts = d;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Posts');
                            }
                    );
        };

        self.fetchAllPosts();

        self.createPost = function (post) {
            PostService.createPost(post)
                    .then(
                            self.fetchAllPosts,
                            function (errResponse) {
                                console.error('Error while creating Post.');
                            }
                    );
        };

        self.updatePost = function (post) {
            PostService.updatePost(post)
                    .then(
                            self.fetchAllPosts,
                            function (errResponse) {
                                console.error('Error while updating Post.');
                            }
                    );
        };

        self.deletePost = function (post) {
            PostService.deletePost(post)
                    .then(
                            self.fetchAllPosts,
                            function (errResponse) {
                                console.error('Error while deleting Post.');
                            }
                    );
        };

        self.submit = function () {
            if (self.post.id === null) {
                console.log('Saving New Post', self.post);
                self.createPost(self.post);
            } else {
                self.updatePost(self.post);
                console.log('Post updated with id ', self.post.id);
                console.log('Post updated to name ', self.post.name);
            }
            self.reset();
        };

        self.edit = function (post) {
            console.log('Post name to be edited', post.name);
            self.post.id = post.id;
            self.post.name = post.name;
            $scope.myForm.$setDirty();
        };

        self.reset = function () {
            self.post = {id: null, name: ''};
            $scope.myForm.$setPristine(); //reset Form
        };

    }]);