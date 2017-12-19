//用户列表控制器
angular.module("cowboyApp").controller("UserListCtrl", function ($scope, $state,$uibModal) {
    var userEntity = {};
    $scope.openAddUserModel = function (size, parentSelector) {
        var parentElem = parentSelector ? parentSelector:angular.element("#container");
        var modalInstance = $uibModal.open({
            animation: true,
            ariaLabelledBy: 'modal-title',
            ariaDescribedBy: 'modal-body',
            templateUrl: 'view/sys/user/userForm.html',
            controller: 'UserFormCtrl',
            controllerAs: '$ctrl',
            size: 'lg6',
            appendTo: parentElem,
            resolve: {
                items: function () {
                    return '100';
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            $ctrl.selected = selectedItem;
        }, function () {
            $log.info('Modal dismissed at: ' + new Date());
        });
    };
});

angular.module("cowboyApp").controller("UserFormCtrl", function ($scope,$uibModalInstance,items, $state,$uibModal) {
    console.log(items);
});
