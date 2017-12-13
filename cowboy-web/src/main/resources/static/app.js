var cowboyApp = angular.module("cowboyApp",[]);
//常量定义----------------------------------------------
cowboyApp.constant('appConstant',{
    appName:'cowboy'
});
//主界面控制器-------------------------------------------
cowboyApp.controller("mainCtrl",function($scope){
    $scope.name = "kakakakakkak";
})