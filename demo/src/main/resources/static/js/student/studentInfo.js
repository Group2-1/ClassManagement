$(document).ready(function() {
    $.ajax({
        url:'/me',
        type:'GET',
        dataType:'json',
        success:function(data){
            $('#username').text(data.id);
            $('#number').text(data.number);
            $('#name').text(data.name);
            $('#school').text(data.school.name);
            $('#email').text(data.email);
            $('#title').text(data.title);
            $('#phone').text(data.phone);
            var g=data.gender;
            if(g=='male')g='男';
            else g='女';
            $('#gender').text(g);
        },
        error:function () {
            alert('me:error');
        }
    });
});

function modifyInfo() {
    window.location.href='/student/infoModify';
}