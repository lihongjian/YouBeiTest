var App = angular.module('MyApp', ['ui.bootstrap']);
App.filter("fen2yuan", ['$filter',function ($filter) {
    return function(input){
        if(input == 1140){
            return $filter('currency')(input/100,'￥')
        }else{
            return input
        }
    }
}]);
App.controller('MyCtrl', ['$scope', function ($scope) {
    //获取列表的请求的参数位置
    $scope.params = {};
    //表格展示的设置，可以设置宽度过滤器等，如果是最后的操作可以使用type="action" 按钮具有action属性，你可以设置操作的方法，如果action="delete"这个你可以在
    //controller里面写删除方法，其余的一次类推，还可以设置按钮的显示条件来做到对按钮的显示控制，这个就是visible方法，里面写判断表达式
    $scope.columns = [
        {
            "type":"data","title":"类库名称","attribute":"name","filter":"fen2yuan"
        },
        {
            "type":"data","title":"类库地址","attribute":"url"
        },
        {
            "type":"action","title":"操作","width":"200","buttons":[
            {
                "title":"删除","className":"btn-sm btn-info","action":"delete",
                "visible":"list.name != '1140'"
            },
            {
                "title":"查看","className":"btn-sm btn-danger","action":"view"
            }
        ]
        }
    ];
    //如果有按钮按钮的操作在这里
    $scope.actions = {
        //第一个参数list是ngrepeat的循环的列表，第二个参数是buttons的循环体
        clicks:function(list,btn){
            switch (btn.action){
                case "delete":
                    //如果你删除后想重新加载列表，只需要在这里调用reload方法
                    $scope.reload();
                    break;
                case "view":
                    alert("view");
                    break
            }
        }
    };
}]);
App.directive('dyTable', ['$http','$filter',function ($http,$filter) {
    /**
     * 依赖angular-ui 的Pagination 因此需要引入angular-ui-bootstrap 以及bootstrap,如果你不想依赖bootstrap的话你可以自己写一个简单的分页
     */
    return {
        restrict:"E",
        templateUrl:'dytable_tpl.html',
        scope:{
            url:'@',
            params:'=',
            columns:'=',
            actions:'=',
            callback:"=?"
        },
        link: function (scope) {
            scope.trs = scope.columns;
            scope.maxSize = 5;
            var url  = scope.url;
            var params = {
                "start":1,
                "length":10
            };
            //初始化
            params = angular.extend(params,scope.params);
            scope.len = params.length;
            scope.bigCurrentPage = params.start;
            //监控分页的变化请求数据
            scope.$watch('bigCurrentPage', function (newVal,oldVal) {
                scope.currentNum = scope.len * newVal;
                if(scope.currentNum > scope.bigTotalItems){
                    scope.currentNum = scope.bigTotalItems;
                }
                params.start = (scope.bigCurrentPage - 1) * scope.len + 1;
                params.length = scope.currentNum;
                //调用获取数据
                scope.getData();
            });
            //获取数据方法
            scope.getData = function () {
                $http({
                    method: 'GET',
                    url:url,
                    params:params
                }).
                    success(function(data, status, headers, config) {
                        scope.originList =data.slice(0,10);  //我这个是自己的测试数据如果你返回的话数据结构应该类似这样{"recordsTotal":80,lists:[{}]}，这个recordsTotal是必须的
                        scope.bigTotalItems = data.recordsTotal; //这个后台返回的数据结构中要含有这个字段，用来计算分页的数量
                        //循环处理添加过滤器
                        angular.forEach(scope.trs,function (ele,i) {
                            if(ele.filter){
                                var filt = ele.filter.split(":");
                                if(filt[0] == "date"){
                                    filt = ["date","yyyy-MM-dd"];
                                }
                                if(filt[0] == "datetime"){
                                    filt = ["date","yyyy-MM-dd HH:mm:ss"];
                                }
                                angular.forEach(scope.originList, function (el,index) {
                                    el[ele.attribute] = $filter(filt[0])(el[ele.attribute],filt[1]);
                                });
                            }
                        });
                        //数据赋值
                        scope.lists = scope.originList;
                    }).
                    error(function(data, status, headers, config) {
                        alert("获取数据出错"); //此处你可以自行撤离如果你使用toastr.error("")如果你引入了这个类库
                    });
            }
            //reload
            scope.callback = function () {
                scope.getData();
            }
        }
    }
}]);