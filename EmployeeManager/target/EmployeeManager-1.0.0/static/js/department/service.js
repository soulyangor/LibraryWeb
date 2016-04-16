'use strict';

App.factory('DepartmentService', ['$http', '$q', function ($http, $q) {

        self.headers = {};
        self.headers["Content-Type"] = 'application/json';

        return {
            fetchAllDepartments: function () {
                return $http.get('http://localhost:8085/EmployeeManager/departments')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching departments');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            createDepartment: function (department) {
                return $http.post('http://localhost:8085/EmployeeManager/departments/item',
                        JSON.stringify(department))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating department');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            updateDepartment: function (currentDepartment, department) {
                return $http.put('http://localhost:8085/EmployeeManager/departments/item',
                        JSON.stringify([currentDepartment, department]))
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while updating department');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            deleteDepartment: function (department) {
                return $http({method: 'DELETE',
                    url: '/EmployeeManager/departments/item/',
                    data: JSON.stringify(department),
                    headers: self.headers})
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while deleting department');
                                    return $q.reject(errResponse);
                                }
                        );
            }

        };
    }]);


