//用户列表控制器
angular.module("cowboyApp").controller("UserListCtrl", function ($scope, $state,$uibModal,httpService) {
    $scope.userEntity = {};

    $scope.dd = "tanginbo"

    //分页结果
    $scope.pageOptions = {
        //用户分页参数
        userPage:{
            pageResult:{}
        }
    }

    //查询用户数据
    $scope.queryUserlist = function(){
        httpService.httpPostJsonParam("/sysUser/getUserList", $scope.userEntity ,{shade:true,shadeParent:'userPageResult'}).then(function(responseData){
            //是否成功
            var isSuccess = httpService.isSuccess(responseData);
            if(isSuccess){
                $scope.pageOptions.userPage.pageResult = httpService.getReusltData(responseData);
            }
        },function(responseData){
            //失败
            alert('失败...');
        });

    }

    //新增,打开弹窗
    $scope.openAddUserModel = function (size, parentSelector) {
        var parentElem = parentSelector ? parentSelector:angular.element("#container");
        var modalInstance = $uibModal.open({
            animation: true,
            ariaLabelledBy: 'modal-title',
            ariaDescribedBy: 'modal-body',
            templateUrl: 'view/sys/user/userForm.html',
            controller: 'UserFormCtrl',
            controllerAs: '$ctrl',
            size: 'lg8',
            appendTo: parentElem,
            resolve: {
                items: function () {
                    return '100';
                }
            }
        });

        //成功
        modalInstance.result.then(function (result) {
            alert(result);
        }, function (result) {
            //取消
            console.log('Modal dismissed at: ' + new Date() + result);
        });
    };
});

//新增或者编辑用户控制层
angular.module("cowboyApp").controller("UserFormCtrl", function ($scope,$uibModalInstance,items,httpService, $state,$uibModal,appConstant) {
    $scope.sysUser = {};
    //取消,关闭弹窗
    $scope.cancel = function(){
        $uibModalInstance.dismiss('cancel');
    }

    //保存用户
    $scope.saveUser = function(){
        //参数验证
        httpService.httpPostJsonParam("/sysUser/saveUser",$scope.sysUser,{shade:true,shadeParent:'addUserForm'}).then(function(responseData){
            //是否成功
           var isSuccess = httpService.isSuccess(responseData);
            if(isSuccess){
                $uibModalInstance.close(appConstant.SUCCESS);
            }
        },function(responseData){
            //失败
            alert('失败...');
        });
    }
});
