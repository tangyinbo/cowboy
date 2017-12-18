var cowboyApp = angular.module("cowboyApp",['ui.router','oc.lazyLoad']);
//常量定义----------------------------------------------
cowboyApp.constant('appConstant',{
    appName:'cowboy'
});
//主界面控制器-------------------------------------------
cowboyApp.controller("MainCtrl",function($scope,$state){
    $scope.name = "kakakakakkak";
    $scope.gotoson1 = function(){
        alert("kaqka")
        $state.go('content1', {
            id: 9999
        });
    }
})
