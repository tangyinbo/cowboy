//懒加载路由配置
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
    $urlRouterProvider.otherwise("/index");
    //当前debug模式,懒加载会打印日志
    $ocLazyLoadProvider.config({
        debug: true
    });
    $stateProvider
        .state('index', {
            url: '/index',
            templateUrl: 'index.html'
        })
        .state('content1', {
            url: '/content1/:id',
            templateUrl: 'test/content1.html',
            controller: 'myLoadCtrl',
            resolve: {
                loader: function ($ocLazyLoad, $q) {
                    //这个return语句一定要有,不然的话刷新浏览器会有问题
                    return $ocLazyLoad.load({
                        files: ['myload.js']
                    });
                }
            }
        })

}

angular.module("cowboyApp").config();