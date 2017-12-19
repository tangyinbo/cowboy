//全局数据中心
var dataCenterService = angular.module("DataCenterService",[]);
//
dataCenterService.run(function(){
    console.log('----------------DataCenterService init ---------------');
});
//全局数据中心
dataCenterService.factory('dataCenter', function($rootScope,$q,httpService) {
    return {
        //获取权限信息
        getPrivs:function(){
            return httpService.httpGet('/config/privs.json');
        }
    }
});