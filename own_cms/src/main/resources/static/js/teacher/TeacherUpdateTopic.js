function getInfo() {

    var topicJson = localStorage.getItem("topicJson");
    if (topicJson != null) {
        topicJson = JSON.parse(topicJson);
        console.log(topicJson);
        $("input[name=seminarName]").val(topicJson.name);
        $("#desc").val(topicJson.description);
        $("input[name=groupLimit]").val(topicJson.groupLimit);
        $("input[name=groupMemberLimit]").val(topicJson.groupMemberLimit);
        $("#serial").text(topicJson.serial);

    }

}

$(function () {
    var topicId = localStorage.getItem("topicId");
    var courseJson = localStorage.getItem("courseJson");
    if (courseJson != null) {
        courseJson = JSON.parse(courseJson);
        $(".courseName").text(courseJson.name);
        $(".courseIntroduction").text(courseJson.description);
    }

    getInfo();

    $(".submit").click(function () {
        var topicInfo = {
            serial:$("#serial").text(),
            groupLimit: $("input[name=groupLimit]").val(),
            name:$("input[name=seminarName]").val(),
            groupMemberLimit:$("input[name=groupMemberLimit]").val(),
            description:$("#desc").val(),
        }

        console.log(topicInfo);

        $.ajax({
            url:"/topic/"+topicId,
            type:"PUT",
            contentType: "application/json",
            data: JSON.stringify(topicInfo),
            success:function () {
                alert("success");
                window.location.href = "/teacher/topicCheck"
            },

            error:function () {
                alert("failed");

            }

        })

    })


    $(".reset").click(function () {
        getInfo();

    })


    $(".returnButton").click(function () {

        window.history.back();

    })

})