angular.module("cowboyApp").factory('httpService', function($rootScope,$http, $q,appConstant) {
    //请求方法
    var requestMethod = {
        get:'GET',
        post:'POST'
    }
    //请求头类型
    var requestHeader = {
        //序列化形式a=1&b=2&c=3&d=4&e=5
        serialize:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}
        //json形式{a:1,b:2,c:3,d:4,e:5}
        ,json:{'Content-Type': 'application/json;charset=utf-8'}
    }
    /**
     * http 请求
     * @returns
     */
    function http(requestOptions,isSerial){
        if(! requestOptions.url){
            throw "url不能为空!";
        }
        //获取数据
        var data = requestOptions.data;
        //是否是序列化参数的形式
        if(data && typeof(isSerial) !="undefined" && Object.prototype.toString.call(isSerial) == '[object Boolean]' && isSerial===true){
            data = $.param(data);
        }
        //定义延迟回调
        var deferred = $q.defer();

        //判断是否要开启加载遮罩
        var isShade = requestOptions.optionParams.shade;
        var el = requestOptions.optionParams.shadeParent;
        el = el ? $('#'+el) : $(defaultParams.shadeParent);
        if(isShade){
            App.blockUI(el);
        }

        $http({
            method: requestOptions.method,
            cache: false,
            data: data,
            headers: requestOptions.headers,
            url: appConstant.appName+requestOptions.url
        }).then(function (response) {
            App.unblockUI(el);
            deferred.resolve(response.data);
        },function (response) {
            App.unblockUI(el);
            //失败返回了响应码
            //数据格式:{data:"",status:""}
            console.error(response);
            deferred.reject(response);
        });
        return deferred.promise;
    }
    //-----------------------------返回服务方法

    //默认参数
    var defaultParams = {
          shade:false,
          shadeParent : 'container'
    }
    return{
        /**
         * 可选参数
         * @param url 请求地址
         * @Param data 请求数据
         * @Param optionParams 可选参数 格式:
         * {
         *    shade: [true/false]  默认fanlse
         *    shadeParent : 遮罩父元素ID,默认 container
         * }
         */
        //序列化参数post请求
        httpPostSerialParam: function (url,data,optionParams) {
            optionParams = angular.extend({},defaultParams,optionParams);
            var defualt
            var requestParam = {
                method:"POST"
                ,cache:false
                ,data:data
                ,headers:requestHeader.serialize
                ,url: url
                ,optionParams:optionParams
            };
            //请求参数为序列化
            return http(requestParam,true,optionParams);
        }
        //json参数类型post请求
        ,httpPostJsonParam:function(url,data,optionParams){
            optionParams = angular.extend({},defaultParams,optionParams);
            var requestParam = {
                method:"POST"
                ,cache:false
                ,data:data
                ,headers:requestHeader.json
                ,url: url
                ,optionParams:optionParams
            };
            return http(requestParam,false);
        }
        //http get
        ,httpGet : function(url,data,optionParams){
            optionParams = angular.extend({},defaultParams,optionParams);
            var requestParam = {
                method:"GET"
                ,cache:false
                ,data:data
                ,headers:requestHeader.serialize
                ,url: url
                ,optionParams:optionParams
            };
            //请求参数为序列化
            return http(requestParam,true);
        }
        //是否成功
        ,isSuccess :function(resultData){
            if(resultData && resultData.code == appConstant.SUCCESS){
                return true;
            }
            return false;
        }
        //获取数据
        ,getReusltData :function(resultData){
           return resultData?resultData.result:null;
        }
        //获取消息
        ,getMsg :function(resultData){
            return resultData?resultData.msg:null;
        }
    }
});