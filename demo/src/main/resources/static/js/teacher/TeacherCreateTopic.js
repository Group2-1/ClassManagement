$(function () {
    var courseJson = localStorage.getItem("courseJson");
    var seminarId = localStorage.getItem("seminarId");
    if (courseJson != null) {
        courseJson = JSON.parse(courseJson);
        $(".courseName").text(courseJson.name);
        $(".courseIntroduction").text(courseJson.description);

    }


    $(".submit").click(function () {
       var topicInfo = {
            serial:$("input[name=serial]").val(),
            groupLimit: $("input[name=groupLimit]").val(),
            name:$("input[name=seminarName]").val(),
            groupMemberLimit:$("input[name=groupMemberLimit]").val(),
            description:$("#desc").val(),
        }

        console.log(topicInfo);

        $.ajax({
            url:"/seminar/" + seminarId + "/topic",
            type:"POST",
            contentType: "application/json",
            data: JSON.stringify(topicInfo),
            success:function () {
                alert("success");
                window.location.href = "/teacher/seminarInfo";
            },

            error:function () {
                alert("failed");
            }
        })
    })




    $(".reset").click(function () {
        $("input[name=seminarName]").val("");
        $("#desc").val("");
        $("input[name=groupLimit]").val("");
        $("input[name=groupMemberLimit]").val("");
        $("input[name=serial]").val("");
    })


/*
    $(".returnButton").click(function () {
        window.history.back();

    })*/

})