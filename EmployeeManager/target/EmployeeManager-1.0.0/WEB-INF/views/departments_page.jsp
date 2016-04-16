<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Список должностей</title>
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
        <div class="generic-container" ng-controller="DepartmentController as ctrl">
            <div class="panel panel-default">
                <div class="panel-heading"><span class="lead">Форма добавления подразделений</span></div>
                <div class="formcontainer">
                    <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                        <input type="hidden" ng-model="ctrl.department.id" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="name">Наименование</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.department.name" 
                                           id="name" 
                                           class="username form-control input-sm" 
                                           placeholder="Введите наименование подразделения" 
                                           required ng-minlength="3"/>
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                        <span ng-show="myForm.name.$error.minlength">Минимальная длина - 3</span>
                                        <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="department">Корневое подразделение</label>
                                <div class="col-md-7">
                                    <select ng-model="ctrl.department.department" 
                                            id="department"
                                            name="department">
                                            
                                        <option value="{{null}}">нет</option>
                                        <option ng-repeat="dep in ctrl.departments" value="{{dep}}">{{dep.name}}</option>
                                    </select> 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit"  
                                       value="{{!ctrl.department.id ? 'Добавить' : 'Изменить'}}" 
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
            <div class="panel-heading"><span class="lead">Список подразделений</span></div>
            <div class="tablecontainer">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Наименование</th>
                            <th>Корневое подразделение</th>
                            <th width="15%"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="d in ctrl.departments">
                            <td><span ng-bind="d.name"></span></td>
                            <td><span ng-bind="d.department.name"></span></td>
                            <td>
                                <button type="button" ng-click="ctrl.edit(d)" 
                                        class="btn btn-success custom-width"
                                        style=" width: 90px !important;">Изменить</button>  
                                <button type="button" 
                                        ng-click="ctrl.deleteDepartment(d)" 
                                        class="btn btn-danger custom-width">Удалить</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="<c:url value='/static/js/lib/angular.min.1.4.9.js' />"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/department/service.js' />"></script>
    <script src="<c:url value='/static/js/department/controller.js' />"></script>
</body>
</html>
