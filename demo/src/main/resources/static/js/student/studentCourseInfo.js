$(document).ready(function() {
    var id=1;
    $.ajax({
        url:'/course/'+id,
        type:'GET',
        dataType:'json',
        data:JSON.stringify({
            'id':id
        }),
        success:function (data) {
            $('#name').text(data.name);
            $('#description').text(data.description);
            $.ajax({
                url:'/course/'+id+'seminar',
                type:'GET',
                dataType:'json',
                contentType: "application/json",
                success:function (data) {
                    var count=data.length;
                    if(count!=0){
                        var parent = $('.blockBody');
                        for(var i=0;i<count;i++){
                            var
                        }
                    }
                }
            });
        }
    });
});

/*
<div class="blockBody">
    <div class="block"><div class="blockFont">讨论课1</div></div>
    <div class="block"><div class="blockFont">讨论课2</div></div>
    <div class="block"><div class="blockFont">讨论课3</div></div>
    <div class="block"><div class="blockFont">讨论课4</div></div>
    <div class="block"><div class="blockFont">讨论课5</div></div>
    <div class="block"><div class="blockFont">讨论课6</div></div>
</div>
 */