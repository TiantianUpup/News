window.onload = function(){
	
	var username = document.getElementById('user');
    var password = document.getElementById('pswd');
    var remember = document.getElementById('remember');
    var submit = document.getElementById('submit');


    //页面初始化时，如果帐号密码cookie存在则填充
    if(getCookie('user') && getCookie('pswd')){
        username.value = getCookie('user');
        password.value = getCookie('pswd');
        remember.checked = true;
    }

    //复选框勾选状态发生改变时，如果未勾选则清除cookie
    remember.onchange = function(){
        if(!this.checked){
            delCookie('user');
            delCookie('pswd');
        }
    };

    // //提交事件触发时，如果复选框是勾选状态则保存cookie
    // submit.onsubmit = function(){
    //     if(remember.checked){
    //         setCookie('user',username.value,7); //保存帐号到cookie，有效期7天
    //         setCookie('pswd',password.value,7); //保存密码到cookie，有效期7天
    //     }
    // };

    //设置cookie
    function setCookie(name,value,day){
        var date = new Date();
        date.setDate(date.getDate() + day);
        document.cookie = name + '=' + value + ';expires='+ date;
    };

    //获取cookie
    function getCookie(name){
        var reg = RegExp(name+'=([^;]+)');
        var arr = document.cookie.match(reg);
        if(arr){
            return arr[1];
        }else{
            return '';
        }
    };

    //删除cookie
    function delCookie(name){
        setCookie(name,null,-1);
    };

    submit.onclick = function(){
        console.log(username.value);
    	if(username.value == '' || password.value == ''){
    		alert("用户名或密码不为空");
    	}else{
    		// 如果复选框是勾选状态则保存cookie
    		/*if(remember.checked){
                setCookie('user',username.value,7); //保存帐号到cookie，有效期7天
                setCookie('pswd',password.value,7); //保存密码到cookie，有效期7天
            }*/

            var xhr = '';
    		var requestData ='';
			var data1 = {
				loginAccount:username.value,
                password:password.value,
                check:true
			};
			//兼容性处理
			if(window.XMLHttpRequest){
			    xhr = new XMLHttpRequest();
			}else{
			    xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}

			xhr.open('POST','/login', true);
			xhr.setRequestHeader("Content-type", "application/json");//添加http头信息，该函数的顺序必须是open之后，send之前
			xhr.send(JSON.stringify(data1));

			//返回响应
			xhr.onreadystatechange = function(){
			    if(xhr.readyState == 4){
			        if(xhr.status >= 200 && xhr.status < 300 || xhr.status == 304){
                        // success(xhr.responseText);
                        requestData = xhr.responseText;
                        var data = JSON.parse(requestData);
                        // console.log(data);
			            // console.log('请求成功');
			            if(data.status == 1){
			                window.location.href = 'add_news.html';
                        }else{
			                console.log('相应参数错误');
                        }
			        }else{
			            //请求数据错误的处理函数
			            console.log('请求错误');
			        }
			    }
			}
    	}
    }
}