function jQueryAjaxTemplate(){
	$.ajax({
		url: 'xxx',
		type: 'post',
		async: 'true', 
		data:{
			'xxx': xxx,
			'xxx': xxx
		},
		error:function(){
			alert("网络中断");
		},
		success:function(result){
			result.xxx;
		}
	});
}

function angularJsHttpTemplate(){
	$http({
        method: 'POST',
        url: 'xxx!xxx.action',
        data:{
        	'xxx': xxx,
        	'xxx': xxx
        }
    }).then(function successCallback(response) {
            $scope.xxx = response.data.xxx;
        }, function errorCallback(response) {
            // 请求失败执行代码
        	console.log(respose);
    });
}

$(document).ready(function(){
	
});

var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
	/** ******************-初始化数据-********************** */
	$scope.username = "";
	$scope.password = "";

	/** ******************-点击事件-********************** */
	// 登陆
	$scope.loginx = function() {
		$http({
			method : 'POST',
			url : '../template/LoginAction!login.action',
			data : {
				'username' : $scope.username,
				'password' : $scope.password
			}
		}).then(function successCallback(response) {
			if(response.data.result){
				window.location.href = "MainFrame.html?username=" + $scope.username;
			}else{
				alert("please check username and password !");
				$scope.password = "";
			}
		}, function errorCallback(response) {
			// 请求失败执行代码
			console.log(respose);
		});
	}	
	
	// 清除
	$scope.clear = function(){
		$scope.username = "";
		$scope.password = "";
	}
});
