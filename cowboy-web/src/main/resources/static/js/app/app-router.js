//懒加载路由配置
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider,$urlMatcherFactoryProvider) {
    $urlMatcherFactoryProvider.strictMode(false);
    $urlRouterProvider.otherwise("/index");
    //当前debug模式,懒加载会打印日志
    $ocLazyLoadProvider.config({
        debug: true
    });
    $stateProvider
        .state('index', {
            url: '/index',
            templateUrl: './view/welcome.html'
        })
        .state('userList', {
            url: '/userList',
            templateUrl: './view/sys/user/userList.html',
            controller: 'UserListCtrl',
            resolve: {
                loader: function ($ocLazyLoad, $q) {
                    //这个return语句一定要有,不然的话刷新浏览器会有问题
                    return $ocLazyLoad.load({
                        files: ['js/app/userController.js']
                    });
                }
            }
        })

}
angular.module("cowboyApp").config(config);