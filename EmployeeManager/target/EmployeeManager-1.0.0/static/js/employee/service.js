'use strict';

App.factory('EmployeeService', ['$http', '$q', function ($http, $q) {

        self.headers = {};
        self.headers["Content-Type"] = 'application/json';

        return {
            fetchAllEmployees: function () {
                return $http.get('/EmployeeManager/employees')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching employees');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            createEmployee: function (employee) {
                return $http.post('/EmployeeManager/employees/item',
                        JSON.stringify(employee))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating employee');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            updateEmployee: function (employee) {
                return $http.put('/EmployeeManager/employees/item',
                        JSON.stringify(employee))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while updating employee');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            deleteEmployee: function (employee) {
                return $http({method: 'DELETE',
                    url: '/EmployeeManager/employees/item/',
                    data: JSON.stringify(employee),
                    headers: self.headers})
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while deleting employee');
                                    return $q.reject(errResponse);
                                }
                        );
            }

        };
    }]);


