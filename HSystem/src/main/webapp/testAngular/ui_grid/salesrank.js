/**
 * Created by hongjian on 2016/1/7.
 */

var salesrank = angular.module('salesrank',[ 'ngAnimate','ngTouch', 'ui.grid']);

salesrank.controller('salesRankCtrl', ['$scope','$http','uiGridConstants',function ($scope,$http,uiGridConstants) {

    $scope.sortArray = [{name:'按数量',property:'sales_volume'},
        {name:'按次数',property:'sales_number'},
        {name:'按金额',property:'sales_amount'}
    ]

    $scope.gridOptions = {
        enableSorting: true,
        columnDefs: [
            { name: $scope.sortArray[0].name, field: 'rank',suppressRemoveSort:true,enableSorting: false,
                menuItems: [
                    {
                        title:  $scope.sortArray[0].name,
                        menuId: $scope.sortArray[0].property,
                        icon: 'ui-grid-icon-info-circled',
                        action: function($event) {
                            this.context.scrope.gridOptions.columnDefs[0].name = $scope.sortArray[0].name;
                            this.context.scrope.gridOptions.columnDefs[3].enableSorting=true;
                            this.context.scrope.gridOptions.columnDefs[4].enableSorting=false;
                            this.context.scrope.gridOptions.columnDefs[5].enableSorting=false;
                        },
                        context: {
                            scrope : $scope,
                            menuId : $scope.sortArray[0].property
                        }
                    },
                    {
                        title:  $scope.sortArray[1].name,
                        menuId: $scope.sortArray[1].property,
                        icon: 'ui-grid-icon-info-circled',
                        action: function($event) {
                            this.context.scrope.gridOptions.columnDefs[0].name = $scope.sortArray[1].name;
                            this.context.scrope.gridOptions.columnDefs[3].enableSorting=false;
                            this.context.scrope.gridOptions.columnDefs[4].enableSorting=true;
                            this.context.scrope.gridOptions.columnDefs[5].enableSorting=false;
                            $scope.grid1Api.core.notifyDataChange( uiGridConstants.dataChange.EDIT );
                        },
                        context: {
                            scrope : $scope,
                            menuId : $scope.sortArray[1].property
                        }
                    },
                    {
                        title:  $scope.sortArray[2].name,
                        menuId: $scope.sortArray[2].property,
                        icon: 'ui-grid-icon-info-circled',
                        action: function($event) {
                            this.context.scrope.gridOptions.columnDefs[0].name = $scope.sortArray[2].name;
                            this.context.scrope.gridOptions.columnDefs[3].enableSorting=false;
                            this.context.scrope.gridOptions.columnDefs[4].enableSorting=false;
                            this.context.scrope.gridOptions.columnDefs[5].enableSorting=true;
                        },
                        context: {
                            scrope : $scope,
                            menuId : $scope.sortArray[2].property
                        }
                    }
                ]},
            { name:'商品名称&规格', field: 'product_name' ,enableColumnMenu: false,enableSorting: false},
            { name:'单位', field: 'units',enableColumnMenu: false,enableSorting: false},
            { name:'销售数量', field: 'sales_volume',suppressRemoveSort:true,enableSorting: true,enableColumnMenu: false},
            { name:'销售次数', field: 'sales_number',suppressRemoveSort:true,enableSorting: false,enableColumnMenu: false},
            { name:'销售金额', field: 'sales_amount',suppressRemoveSort:true,enableSorting: false,enableColumnMenu: false}
        ],

        onRegisterApi: function( gridApi ) {
            $scope.grid1Api = gridApi;
        }
    };

    $http.get('../100.json')
        .success(function(data) {
            $scope.gridOptions.data = data;
        });

}]);