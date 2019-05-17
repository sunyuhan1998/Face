function login(){
	$.ajax({
		url:"LoginServlet",
		method:"post",
		data:{
			username:$("#username").val(),
			password:$("#password").val()
		},
		type:"json",
		success:function(data){
			alert(data);
		}
	})
}