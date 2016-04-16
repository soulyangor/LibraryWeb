'use strict';

App.controller('DepartmentController', ['$scope', 'DepartmentService',
    function ($scope, DepartmentService) {
        var self = this;
        self.department = {id: null, name: '', department: null};
        self.currentDepartment = {id: null, name: '', department: null};
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
            DepartmentService.updateDepartment(self.currentDepartment, department)
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
            if (self.department.id === null) {
                console.log('Saving New Department', self.department);
                self.createDepartment(self.department);
            } else {
                self.updateDepartment(self.department);
                console.log('Department updated with name ', self.currentDepartment.name);
                console.log('Department updated to name ', self.department.name);
            }
            self.reset();
        };

        self.edit = function (department) {
            console.log('Department to be edited', department);
            console.log('RootDepartment ', department.department);
            self.currentDepartment = department;
            self.department = department;
            $scope.myForm.$setDirty();
        };

        self.reset = function () {
            self.department = {id: null, name: '', department: null};
            $scope.myForm.$setPristine(); //reset Form
        };

    }]);