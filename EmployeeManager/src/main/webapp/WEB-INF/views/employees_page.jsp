<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Список сотрудников</title>
        <style>
            .username.ng-valid {
                background-color: lightgreen;
            }
            .username.ng-dirty.ng-invalid-required {
                background-color: red;
            }
            .username.ng-dirty.ng-invalid-minlength {
                background-color: yellow;
            }
        </style>
        <link href="<c:url value='/static/css/lib/bootstrap.min.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
        <script src="<c:url value='/static/js/lib/jquery-1.12.0.min.js' />"></script>
        <script src="<c:url value='/static/js/lib/jquery-ui.min.js' />"></script>
    </head>
    <body class="ng-cloak" ng-app="myApp">
        <div class="generic-container" ng-controller="EmployeeController as ctrl">
            <div class="panel panel-default">
                <div class="panel-heading"><span class="lead">Форма добавления сотрудников</span></div>
                <div class="formcontainer">
                    <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                        <input type="hidden" ng-model="ctrl.employee.id" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="lastname">Фамилия</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.employee.lastname" 
                                           id="lastname" 
                                           class="username form-control input-sm" 
                                           placeholder="Введите фамилию сотрудника" 
                                           required ng-minlength="1"/>
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                        <span ng-show="myForm.name.$error.minlength">Минимальная длина - 1</span>
                                        <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="firstname">Имя</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.employee.firstname" 
                                           id="firstname" 
                                           class="username form-control input-sm" 
                                           placeholder="Введите имя сотрудника" 
                                           required ng-minlength="2"/>
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                        <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                        <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="secondname">Отчество</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.employee.secondname" 
                                           id="secondname" 
                                           class="username form-control input-sm" 
                                           placeholder="Введите отчество сотрудника" 
                                           required ng-minlength="5"/>
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                        <span ng-show="myForm.name.$error.minlength">Минимальная длина - 5</span>
                                        <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-12" ng-controller="DepartmentController as depctrl">
                                <label class="col-md-2 control-lable" for="department">Подразделение</label>
                                <div class="col-md-7">
                                    <select ng-model="ctrl.employee.department" 
                                            id="department"
                                            name="department">
                                        <option ng-repeat="dep in depctrl.departments" value="{{dep}}">{{dep.name}}</option>
                                    </select> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-12" ng-controller="PostController as postctrl">
                                <label class="col-md-2 control-lable" for="post">Должность</label>
                                <div class="col-md-7">
                                    <select ng-model="ctrl.employee.post" 
                                            id="post"
                                            name="post">
                                        <option ng-repeat="p in postctrl.posts" value="{{p}}">{{p.name}}</option>
                                    </select> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit"  
                                       value="{{!ctrl.employee.id ? 'Добавить' : 'Изменить'}}" 
                                       class="btn btn-primary btn-sm" 
                                       ng-disabled="myForm.$invalid">
                                <button type="button" 
                                        ng-click="ctrl.reset()" 
                                        class="btn btn-warning btn-sm" 
                                        ng-disabled="myForm.$pristine">Сбросить</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Список сотрудников</span></div>
            <div class="tablecontainer">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ФИО</th>
                            <th>Подразделение</th>
                            <th>Должность</th>
                            <th width="20%"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="e in ctrl.employees">
                            <td><span ng-bind="e.lastname + ' ' + e.firstname + ' ' + e.secondname"></span></td>
                            <td><span ng-bind="e.department.name"></span></td>
                            <td><span ng-bind="e.post.name"></span></td>
                            <td>
                                <button type="button" ng-click="ctrl.edit(e)" 
                                        class="btn btn-success custom-width"
                                        style=" width: 90px !important;">Изменить</button>  
                                <button type="button" 
                                        ng-click="ctrl.deleteEmployee(e)" 
                                        class="btn btn-danger custom-width"
                                        style=" width: 90px !important;">Удалить</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="<c:url value='/static/js/lib/angular.min.1.4.9.js' />"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/employee/service.js' />"></script>
    <script src="<c:url value='/static/js/employee/controller.js' />"></script>
     <script src="<c:url value='/static/js/department/service.js' />"></script>
    <script src="<c:url value='/static/js/department/controller.js' />"></script>
     <script src="<c:url value='/static/js/post/service.js' />"></script>
    <script src="<c:url value='/static/js/post/controller.js' />"></script>
</body>
</html>
