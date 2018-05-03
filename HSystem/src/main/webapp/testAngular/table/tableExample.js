var App = angular.module('MyApp', ['ui.bootstrap']);
App.filter("fen2yuan", ['$filter',function ($filter) {
    return function(input){
        if(input == 1140){
            return $filter('currency')(input/100,'��')
        }else{
            return input
        }
    }
}]);
App.controller('MyCtrl', ['$scope', function ($scope) {
    //��ȡ�б������Ĳ���λ��
    $scope.params = {};
    //���չʾ�����ã��������ÿ�ȹ������ȣ���������Ĳ�������ʹ��type="action" ��ť����action���ԣ���������ò����ķ��������action="delete"����������
    //controller����дɾ�������������һ�����ƣ����������ð�ť����ʾ�����������԰�ť����ʾ���ƣ��������visible����������д�жϱ��ʽ
    $scope.columns = [
        {
            "type":"data","title":"�������","attribute":"name","filter":"fen2yuan"
        },
        {
            "type":"data","title":"����ַ","attribute":"url"
        },
        {
            "type":"action","title":"����","width":"200","buttons":[
            {
                "title":"ɾ��","className":"btn-sm btn-info","action":"delete",
                "visible":"list.name != '1140'"
            },
            {
                "title":"�鿴","className":"btn-sm btn-danger","action":"view"
            }
        ]
        }
    ];
    //����а�ť��ť�Ĳ���������
    $scope.actions = {
        //��һ������list��ngrepeat��ѭ�����б��ڶ���������buttons��ѭ����
        clicks:function(list,btn){
            switch (btn.action){
                case "delete":
                    //�����ɾ���������¼����б�ֻ��Ҫ���������reload����
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
     * ����angular-ui ��Pagination �����Ҫ����angular-ui-bootstrap �Լ�bootstrap,����㲻������bootstrap�Ļ�������Լ�дһ���򵥵ķ�ҳ
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
            //��ʼ��
            params = angular.extend(params,scope.params);
            scope.len = params.length;
            scope.bigCurrentPage = params.start;
            //��ط�ҳ�ı仯��������
            scope.$watch('bigCurrentPage', function (newVal,oldVal) {
                scope.currentNum = scope.len * newVal;
                if(scope.currentNum > scope.bigTotalItems){
                    scope.currentNum = scope.bigTotalItems;
                }
                params.start = (scope.bigCurrentPage - 1) * scope.len + 1;
                params.length = scope.currentNum;
                //���û�ȡ����
                scope.getData();
            });
            //��ȡ���ݷ���
            scope.getData = function () {
                $http({
                    method: 'GET',
                    url:url,
                    params:params
                }).
                    success(function(data, status, headers, config) {
                        scope.originList =data.slice(0,10);  //��������Լ��Ĳ�����������㷵�صĻ����ݽṹӦ����������{"recordsTotal":80,lists:[{}]}�����recordsTotal�Ǳ����
                        scope.bigTotalItems = data.recordsTotal; //�����̨���ص����ݽṹ��Ҫ��������ֶΣ����������ҳ������
                        //ѭ��������ӹ�����
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
                        //���ݸ�ֵ
                        scope.lists = scope.originList;
                    }).
                    error(function(data, status, headers, config) {
                        alert("��ȡ���ݳ���"); //�˴���������г��������ʹ��toastr.error("")�����������������
                    });
            }
            //reload
            scope.callback = function () {
                scope.getData();
            }
        }
    }
}]);