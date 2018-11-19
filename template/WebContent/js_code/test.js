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
	/********************-初始化数据聲明【需保存至數據庫】-***********************/
	$scope.reportData = {
			"sendDeptList":[]
	};// 報告數據
	$scope.reportData.sendDeptList = [];// 分發單位list
	
	/********************-初始化数据聲明【頁面數據源】-***********************/
	$scope.sendDeptList = [];// 分發單位list
	$scope.userList = [];
	
	/********************-異步請求-***********************/
	// 查询分发单位
	$scope.querySendDept = function(){
		$http({
	        method: 'POST',
	        url: '../test/TestAction!querySendDept.action',
	        data:{
	        }
	    }).then(function successCallback(response) {
	            var vdata = response.data.sendDeptList;
				var li = [];
				var f = 0;
				for(var i = 0; i < vdata.length; i++){
					vdata[i].checked = false;
					if((i + 1) % 6 == 0){
						li.push(vdata[i]);
						$scope.sendDeptList.push(li);
						var li = [];
						f = 1;
					}else{
						f = 0;
						li.push(vdata[i]);
					}
				}
				if(f == 0){
					$scope.sendDeptList.push(li);
				}
	        }, function errorCallback(response) {
	            // 请求失败执行代码
	        	alert("請求失敗");
	    });
	}
	
	// 查询用户list
	$scope.queryUserList = function(){
		$http({
			method: 'POST',
			url: '../test/TestAction!queryUserList.action',
			data:{
			}
		}).then(function successCallback(response) {
			$scope.userList = response.data.userList;
			alert($scope.userList);
		}, function errorCallback(response) {
			// 请求失败执行代码
		});
	}
	
	/********************-初始化頁面數據源-***********************/
	$scope.initPageData = function(){
		//$scope.querySendDept();
		$scope.queryUserList();
	}
	$scope.initPageData();
	
	/********************-点击事件-***********************/
	
});

