$(function () {

    var groupId = localStorage.getItem("groupId");
    var seminarId = localStorage.getItem("seminarId");
    console.log(groupId);

    $.ajax({
        url:"/seminar/"+seminarId+"/group",
        type: "GET",
        success: function (data) {
            if (data.length != undefined) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i].id == groupId) {
                        $("#group").html(data[i].name);
                        // console.log(data[i].name);

                    }
               }
           }
        }

    });



    $.ajax({
        url:"/group/"+groupId,
        type: "GET",
        success: function (data) {
            console.log(data);
            $("#leader").text(data.leader.name);
        }
    });

    $.ajax({ 	
        url:"/seminar/"+seminarId,
        type: "GET",
        success: function (data) {
            $("#title").text(data.name);
        }
    });



    //设置小组的报告分

    $("#giveScore").click(function () {
        var score = {reportGrade: $("#grade").val()};
        console.log(score);
        $.ajax({
            url:"/group/" + groupId + "/grade/report",
            type:"PUT",
            contentType: "application/json",
            data: JSON.stringify(score),
            success:function () {
                window.location.href = "/teacher/scoreHome";
            }

        });

    });

});