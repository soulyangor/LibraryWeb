'use strict';

App.controller('DepartmentController', ['$scope', 'DepartmentService',
    function ($scope, DepartmentService) {
        var self = this;
        self.department = {id: null, name: '', department: null};
        self.departments = [];

        self.fetchAllDepartments = function () {
            DepartmentService.fetchAllDepartments()
                    .then(
                            function (d) {
                                self.departments = d;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Departments(controller)');
                            }
                    );
        };

        self.fetchAllDepartments();

        self.createDepartment = function (department) {
            DepartmentService.createDepartment(department)
                    .then(
                            self.fetchAllDepartments,
                            function (errResponse) {
                                console.error('Error while creating Department(controller)');
                            }
                    );
        };

        self.updateDepartment = function (department) {
            DepartmentService.updateDepartment(department)
                    .then(
                            self.fetchAllDepartments,
                            function (errResponse) {
                                console.error('Error while updating Department(controller)');
                            }
                    );
        };

        self.deleteDepartment = function (department) {
            DepartmentService.deleteDepartment(department)
                    .then(
                            self.fetchAllDepartments,
                            function (errResponse) {
                                console.error('Error while deleting Department(controller)');
                            }
                    );
        };

        self.submit = function () {
            console.log('root - ' + self.department.department);
            var root = self.department.department !== null ?
                    JSON.parse(self.department.department) : null;
            self.department.department = root;
            if (self.department.id === null) {
                console.log('Saving New Department', self.department);
                self.createDepartment(self.department);
            } else {
                self.updateDepartment(self.department);
                console.log('Department updated to  ', self.department);
            }
            self.reset();
        };

        self.edit = function (department) {
            console.log('Department name to be edited', department);
            var root = (department.department !== null) ?
                    JSON.stringify(department.department) : null;
            self.department = department;
            self.department.department = root;
            $scope.myForm.$setDirty();
        };

        self.reset = function () {
            self.department = {id: null, name: '', department: null};
            $scope.myForm.$setPristine(); //reset Form
        };

    }]);