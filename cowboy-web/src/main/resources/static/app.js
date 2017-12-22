var cowboyApp = angular.module("cowboyApp", ['ui.router'
    , 'oc.lazyLoad'
    , 'DataCenterService'
    , 'ngAnimate'
    ,'anim-in-out'
    ,'ui.bootstrap'
    ,'multiselect-searchtree'
]);
//常量定义----------------------------------------------
cowboyApp.constant('appConstant', {
    appName: '/cowboy',
    SUCCESS:'10200',
    FAIL:'10201'
});
//主界面控制器-------------------------------------------
cowboyApp.controller("MainCtrl", function ($scope, $state) {
    $scope.globalConf = {
        searchPriv:''
    }



    //界面切换动画
    var ctrlType = ["anim-fade","anim-slide-left","anim-slide-right","anim-zoom-in","anim-zoom-out","anim-zoom-in-full","anim-zoom-out-full","anim-slide-below","anim-slide-below-fade"];
    //动画
    var ctrl = this;
    ctrl.speed = 200;
    ctrl.sync = true;
    ctrl.mainViewStyle = 'anim-zoom-in';
    //界面切换动画

    //跳转
    $scope.goToState = function(priv,params){
        //判断菜单是否有子菜单,如果有子菜单不跳转
        if(!priv || priv.subPriv && priv.subPriv.length>0 || !priv.state){
            return;
        }
        var params = angular.extend({}, params?params:{});
        $state.go(priv.state, params);
    }


    $scope.gotoson1 = function () {
        $state.go('content1', {
            id: 9999
        });
    }
});

/**
 * 加载全局属性变量
 */
cowboyApp.run(function ($rootScope, $timeout, dataCenter) {
    //获取权限信息
    dataCenter.getPrivs().then(function (responseData) {
        $rootScope.privs = angular.fromJson(responseData);
    }, function (responseData) {
        var status = responseData.status;
        alert('请求失败,失败编码:' + status);
    });
});
