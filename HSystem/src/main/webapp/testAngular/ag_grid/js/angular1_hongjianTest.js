/**
 * Created by hongjian on 2016/1/6.
 */
var module = angular.module("example", ["agGrid"]);

module.controller("exampleCtrl", function($scope, $http,$timeout) {

    var columnDefs = [
        {headerName: "Athlete", field: "athlete", width: 150},
        {headerName: "Age", field: "age", width: 90},
        {headerName: "Country", field: "country", width: 120},
        {headerName: "Year", field: "year", width: 90, unSortIcon: true},
        {headerName: "Date", field: "date", width: 110},
        {headerName: "Sport", field: "sport", width: 110,editable: true,newValueHandler: upperCaseNewValueHandler},
        {headerName: "Hobby", field: "hobby", width: 110,cellRenderer: customEditorUsingAngular},
        {headerName: "Gold", field: "gold", width: 100},
        {headerName: "Silver", field: "silver", width: 100},
        {headerName: "Bronze", field: "bronze", width: 100},
        {headerName: "Total", field: "total", width: 100,valueGetter:'data.gold + data.silver + data.bronze'},
        {headerName: "Average", width: 100,valueGetter:getAverage}
    ];

    $scope.gridOptions = {
        columnDefs: columnDefs,
        showToolPanel:true,
        enableSorting: true,
        angularCompileRows: true,
        enableColResize: true,
        rowSelection: 'multiple'

    };

    function getAverage(params){
        return params.data.gold + params.data.silver;
    }

    $http.get("olympicWinners.json")
        .then(function(res){
            $scope.gridOptions.api.setRowData(res.data);
        });

    $scope.deleteRow = function(){
        var rows = $scope.gridOptions.getSelectedRows();
        alert(rows);
    }

    $scope.addRow = function(){

    }

    var setSelectionOptions = ['AAA','BBB','CCC','DDD','EEE','FFF','GGG'];

    function customEditorUsingAngular(params) {
        params.$scope.setSelectionOptions = setSelectionOptions;

        var html = '<span width="100%" ng-show="!editing" ng-click="startEditing()">{{data.'+params.colDef.field+'}}</span> ' +
            '<select width="100%" ng-blur="editing=false" ng-change="editing=false" ng-show="editing" ' +
            'ng-options="item for item in setSelectionOptions" ng-model="data.'+params.colDef.field+'">';

        // we could return the html as a string, however we want to add a 'onfocus' listener, which is no possible in AngularJS
        var domElement = document.createElement("span");
        domElement.innerHTML = html;

        params.$scope.startEditing = function() {
            params.$scope.editing = true; // set to true, to show dropdown

            // put this into $timeout, so it happens AFTER the digest cycle,
            // otherwise the item we are trying to focus is not visible
            $timeout(function () {
                var select = domElement.querySelector('select');
                select.focus();
            }, 0);
        };

        return domElement;
    }
    function upperCaseNewValueHandler(params) {
        params.data[params.colDef.field] = params.newValue.toUpperCase();
    }

});
