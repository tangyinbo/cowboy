angular.module("heroApp").controller('myLoadCtrl',function ($scope,$stateParams, $state, $scope) {
    // sayHello();
    alert('ddddd')
    $scope.name = "tangyinbo ni hao ya!";

    $scope.gotoson1 = function () {
        $state.go('content1.son1', {
            id: 9999
        });
    }
});