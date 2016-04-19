'use strict';

App.controller('EmployeeController', ['$scope', 'EmployeeService',
    function ($scope, EmployeeService) {
        var self = this;
        self.employee = {
            id: null,
            firstname: '',
            secondname: '',
            lastname: '',
            department: null,
            post: null
        };
        self.employees = [];

        self.fetchAllEmployees = function () {
            EmployeeService.fetchAllEmployees()
                    .then(
                            function (d) {
                                self.employees = d;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Employees(controller)');
                            }
                    );
        };

        self.fetchAllEmployees();

        self.createEmployee = function (employee) {
            EmployeeService.createEmployee(employee)
                    .then(
                            self.fetchAllEmployees,
                            function (errResponse) {
                                console.error('Error while creating Employee(controller)');
                            }
                    );
        };

        self.updateEmployee = function (employee) {
            EmployeeService.updateEmployee(employee)
                    .then(
                            self.fetchAllEmployees,
                            function (errResponse) {
                                console.error('Error while updating Employee(controller)');
                            }
                    );
        };

        self.deleteEmployee = function (employee) {
            EmployeeService.deleteEmployee(employee)
                    .then(
                            self.fetchAllEmployees,
                            function (errResponse) {
                                console.error('Error while deleting Employee(controller)');
                            }
                    );
        };
        //TO DO...
        self.submit = function () {
            console.log('department - ' + self.employee.department);
            var department = self.employee.department !== null ?
                    JSON.parse(self.employee.department) : null;
            var post = self.employee.post !== null ?
                    JSON.parse(self.employee.post) : null;
            self.employee.department = department;
            self.employee.post = post;
            if (self.employee.id === null) {
                console.log('Saving New Employee', self.employee);
                self.createEmployee(self.employee);
            } else {
                self.updateEmployee(self.employee);
                console.log('Employee updated to  ', self.employee);
            }
            self.reset();
        };

        self.edit = function (employee) {
            console.log('Employee name to be edited', employee);
            var department = (employee.department !== null) ?
                    JSON.stringify(employee.department) : null;
            var post = (employee.post !== null) ?
                    JSON.stringify(employee.post) : null;
            self.employee = employee;
            self.employee.department = department;
            self.employee.post = post;
            $scope.myForm.$setDirty();
        };

        self.reset = function () {
            self.employee = {
                id: null,
                firstname: '',
                secondname: '',
                lastname: '',
                department: null,
                post: null
            };
            $scope.myForm.$setPristine(); //reset Form
        };

    }]);