angular.module('heroApp', ['ui.router','oc.lazyLoad'])
//---------------
    .controller('MainCtrl', function MainCtrl() {
        this.hero = {
            name: 'Spawn'
        };
    })

    .component('heroDetail', {
        templateUrl: 'heroDetail.html',
        bindings: {
            hero: '='
        }
    })

    .config(function ($stateProvider,$$qProvider, $urlRouterProvider,$ocLazyLoadProvider) {
        $urlRouterProvider.otherwise("/index");
        $ocLazyLoadProvider.config({
            debug: true
        });

        $stateProvider
            .state('home',{
                url:'/index',
                templateUrl:'index.html'
            })
            .state('content1', {
                url: '/content1/:id',
                templateUrl: 'content1.html',
      /*          controller:function($stateParams,$state,$scope){
                   // sayHello();
                  console.log($stateParams);

                    $scope.gotoson1 = function(){
                        $state.go('content1.son1', {
                            id: 9999
                        });
                    }
                },*/
                controller:'myLoadCtrl',
                resolve :{
                    loader:function($ocLazyLoad,$q){
                        //这个return语句一定要有,不然的话刷新浏览器会有问题
                        return $ocLazyLoad.load({
                            files: ['myload.js']
                        });
                    }
                }
            })
        $stateProvider
            .state('content1.son1', {
                url: '/son1',
                template:"<div>hello content1.xxx</div>",
                controller:function($stateParams){
                }
            })
        $stateProvider
            .state('content2', {
                url: '/content3',
                templateUrl: 'content2.html'
            })
    });