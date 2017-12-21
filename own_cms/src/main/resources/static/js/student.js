$(document).ready(function() {
    $.ajax({
        url:'/me',
        type:'GET',
        dataType:'json',
        success:function(data){
            $('#username').text(data.id);
            $('#number').text(data.number);
            $('#name').text(data.name);
            var g=data.gender;
            if(g=='MALE')g='男';
            else g='女';
            $('#gender').text(g);
            $('#school').text(data.school.name);
            $('#education').text('本科');
            $('#email').text(data.email);
            $('#phone').text(data.phone);
        },
        error:function () {
            alert('me:error');
        }
    });
});