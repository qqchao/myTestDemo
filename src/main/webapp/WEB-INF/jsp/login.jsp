<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<h2 style="color:red">haha! This is Login Page!</h2>
<h3>If you see this page , you have deployed the app successful!</h3>
<a href="https://www.baidu.com" target="view_window" 
	style="text-decoration:none">How are you ？</a>
	
	<button id="aaa" onclick="aclick()">aaa</button>
	<div style="height:20px;"></div>
	<form name="myform" id="myform" method="post" target="hidden_frame" enctype="multipart/form-data">
		
		<tr>
			<td >附件</td>
			<td ><input type="file" name="file" id="file"></td>
		</tr>
	</form>
	<div style="height:20px;">
	</div>
	<button onclick="confimSubmit()" type="button" id="submitOrder">提交</button>
	
	<script type="text/javascript">
		document.getElementById("aaa").onclick = function(){
			$.ajax({
				url : "http://localhost/testDemo/user/testDelete",
				data :{"aaa":"aaa",
					"_method":"delete"
					},
				type:"post",
				dataType:"json",
				async : false,
				success : function(json){
					alert("yeah~");
				}
			});
		}
		
		function aclick(){
			alert(111);
		}
		
		function confimSubmit() {
			alert("submit");
			var f = $("#file").val();

			if (f == null || f == "") {
				alert("请选择上传文件！");
				retrun;
			}

			var form = new FormData(document.getElementById("myform"));
			
			alert(form);
			
			$.ajax({
				url : "http://localhost/testDemo/test/testUpload",
				type : "post",
				data : form,
				processData : false,
				contentType : false,
				success : function(data) {
					
				},
				error : function(e) {
					
				}
			});
		}
	</script>
	
	<script  type="text/javascript" src="../resources/js/jquery.js"></script>
	<script  type="text/javascript" src="../resources/js/jquery-3.1.1.min.js"></script>
</body>
</html>
