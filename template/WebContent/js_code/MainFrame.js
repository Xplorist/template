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
    });
}

$(document).ready(function(){
	
});

var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
	/********************-獲取參數變量-***********************/
	$scope.getUrlfn = function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return decodeURI(r[2]);
		return null;
	}
	$scope.username = $scope.getUrlfn("username");
	/********************-初始化数据聲明【需保存至數據庫】-***********************/
	$scope.menuData = [
		{"menuName":"add"},
		{"menuName":"query"}
	];
	/********************-初始化数据聲明【頁面數據源】-***********************/
	$scope.timestamp = "";
	$scope.nowtime = function() {
		setInterval(function() {
			var myDate = new Date();// 获取系统当前时间
			$scope.timestamp = myDate.toLocaleString();
			$scope.$apply();
		}, 1000);
	};
	$scope.nowtime();
	/********************-異步請求-***********************/
	
	
	/********************-初始化頁面數據源-***********************/
	$scope.initPageData = function(){
	}
	$scope.initPageData();
	/********************-点击事件-***********************/
	$scope.signout = function(){
		window.location.href = "login.html";
	}
	  
});


	 

