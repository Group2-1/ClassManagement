/*登录*/
function login(){
    $.ajax({
        url:"/signin",
        type:"POST",
        dataType:"json",
        data:{
            "phone":$(".UserNameField").val(),
            "password":$(".PasswordField").val()
        },
        success:function (data) {
            alert(data);
            if(data.type=='student'){
                window.location.href='/student/courseHome';
            }
            else{
                window.location.href='/teacher/courseHome';
            }
        },
        error:function () {
            alert("error");
        }
    });
}

/*注册*/
function register() {
    $.ajax({
        url:"/register",
        type:"POST",
        dataType:'json',
        data:{
            'phone':'18911114514',
            'password':'qwer2345!'
        },
        success:function (data) {
            alert('register1:success');
            $.ajax({
                url:'/me',
                type:'PUT',
                dataType:'json',
                data:{
                    'name':'张三',
                    'type':'student',
                    'school':{
                        'id':32,
                        'name':'厦门大学'
                    },
                    'gender':'male',
                    'number':'24320152202333',
                    'email':'xxxxx@xx.com'
                },
                success:function (data) {
                    alert('register2:success');
                },
                error:function () {
                    alert('register2:error');
                }
            });
        },
        error:function(data){
            alert('register1:error');
        }
    });
}

/*绑定*/
function bind() {
    $.ajax({
       url:"/me",
       type:"PUT",
       dataType:'json',
       data:{
           "name": "张三",
           "school": {
               "id": 32,
               "name": "厦门大学"
           },
           "gender": "male",
           "number": "24320152202333",
           "email": "xxxxx@xx.com"
       },
        success:function (data) {
            alert('bind:Success');
        },
        error:function () {
            alert('bind:error');
        }
    });
}
