$(function(){
    $.ajax({
        url:'/me',
        type:'GET',
        dataType:'json',
        success:function(data){
            $('#username').text(data.id);
            $('#number').val(data.number);
            $('#name').val(data.name);
            $('#school').val(data.school.name);
            $('#email').val(data.email);
            $('#phone').val(data.phone);
            $('#title').val(data.title);
            var g=data.gender;
            if(g=='male')g='男';
            else g='女';
            $('#gender').val(g);
        },
        error:function () {
            alert('me:error');
        }
    });
});

function submitInfo() {
    var g=$('#gender').val();
    if(g=='男')g='male';
    else g='female';
    $.ajax({
        url:'/me',
        type:'PUT',
        dataType:'json',
        contentType: "application/json; charset=utf-8",
        data:JSON.stringify({
            "name": $('#name').val(),
            "school": $('#school').val(),
            "gender": g,
            "phone":$('#phone').val(),
            "number": $('#number').val(),
            "email": $('#email').val(),
            "title":$('#title').val(),
            'avatar':'/avater/3486.png'
        }),
        success:function () {
            alert("提交成功");
            window.location.href='/student/home';
        },
        error:function () {
            alert('submitInfo:error');
        }
    });
}