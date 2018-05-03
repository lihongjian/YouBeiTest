/**
 * Created by hongjian on 2016/1/7.
 */
var tableModule = angular.module("tableModule",[]);

tableModule.controller("basicController",function($scope,$http){

    $scope.columnDefs = [
        {headerName: "Athlete", field: "athlete", width: 150},
        {headerName: "Age", field: "age", width: 90},
        {headerName: "Country", field: "country", width: 120},
        {headerName: "Year", field: "year", width: 90},
        {headerName: "Date", field: "date", width: 110},
        {headerName: "Sport", field: "sport", width: 110},
        {headerName: "Hobby", field: "hobby", width: 110},
        {headerName: "Gold", field: "gold", width: 100},
        {headerName: "Silver", field: "silver", width: 100},
        {headerName: "Bronze", field: "bronze", width: 100}
    ];

    $scope.newRow = function(){
        return {"athlete":"Natalie Coughlin","age":25,"country":"United States","year":2008,"date":"24/08/2008","sport":"Swimming","hobby":"BBB","gold":1,"silver":2,"bronze":3,"total":6};
    };

    $scope.data = [{"athlete":"Michael Phelps","age":23,"country":"United States","year":2008,"date":"24/08/2008","sport":"Swimming","hobby":"BBB","gold":8,"silver":0,"bronze":0,"total":8},
        {"athlete":"Michael Phelps","age":19,"country":"United States","year":2004,"date":"29/08/2004","sport":"Swimming","hobby":"BBB","gold":6,"silver":0,"bronze":2,"total":8},
        {"athlete":"Michael Phelps","age":27,"country":"United States","year":2012,"date":"12/08/2012","sport":"Swimming","hobby":"BBB","gold":4,"silver":2,"bronze":0,"total":6},
        {"athlete":"Natalie Coughlin","age":25,"country":"United States","year":2008,"date":"24/08/2008","sport":"Swimming","hobby":"BBB","gold":1,"silver":2,"bronze":3,"total":6}];

    //$http.get("data.json")
    //    .then(function(res){
    //        $scope.data = res.data;
    //});

    $scope.rowCollection = [];
    for(var i = 0 ; i < $scope.data.length ; i++ ){
        $scope.rowCollection.push($scope.data[i]);
    }

    $scope.clickOne = function(){

    }

    $scope.onAddLine = function(){
        $scope.rowCollection.push($scope.newRow());
    }

    $scope.onDeleteLine = function(rowdata){
        var index = $scope.rowCollection.indexOf(rowdata);
        if(index!=-1){
            $scope.rowCollection.splice(index, 1);
        }
    }

});