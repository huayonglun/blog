$(document).ready(function(){
	$("#zhuce").click(function(){
		var useranme = $("#zc-username").val();
		var password = $("#inputPassword3").val();
		var comfrimPassword = $("#inputPassword4").val();
		if(password != comfrimPassword){
		$ ("#zc-tishi").html($ ("#zc-tishi").html () + "前后密码不一致！");
		}else{
			UserManager.insert(useranme,password,function(){
				location.href="blog.html";
			});
		}
	});
});