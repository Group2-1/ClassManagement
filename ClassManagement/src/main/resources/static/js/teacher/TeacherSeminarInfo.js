$(function () {

    var seminarId = localStorage.getItem("seminarId");
    console.log(seminarId);
    var courseJson = localStorage.getItem("courseJson");

    if (courseJson != undefined) {
        courseJson = JSON.parse(courseJson);
        $(".courseName").text(courseJson.name);
        $(".courseIntroduction").text(courseJson.description);
    }



    $.ajax({
        url:"/seminar/"+seminarId,
        type: "GET",
        success: function (data) {
            console.log(data);
            var json = JSON.stringify(data);
            localStorage.setItem("seminarJson", json);
            $("#seminarTitle").text(data.name);
            $("#name").text(data.nema);
            $("#desc").text(data.description);
            $("#groupModel").text(data.groupingMethod == "fixed" ? "固定分组" : "随机分组");
            $("#startTime").text(data.startTime);
            $("#endTime").text(data.endTime);

            if (data.topics.length != undefined) {
                for (var i = 0; i < data.topics.length; i++) {
                    $("#topicContent").append("  <div class=\"topicBlock\" id=" + data.topics[i].id + " name='topic'>\n" +
                        "                        <div class=\"topicBlockFont\">" + data.topics[i].name + "</div>\n" +
                        "                    </div>")
                }

            }

  
            $("#topicContent").append("<div class=\"topicBlock\" id='addTopic'>\n" +
                "                        <img class=\"addImg\" src=\"/img/smalladd.png\" alt=\"添加\">\n" +
                "                    </div>")
        }

    })


    $(".body").on("click", "#grade", function () {
        window.location.href = "/teacher/scoreHome";
    })

    $(".body").on("click", "#modily", function () {
        window.location.href = "/teacher/updateSeminar";
    })


    $(".body").on("click", "#delete", function () {
        if (confirm("确认删除该讨论课吗？")) {
            console.log(seminarId);
            $.ajax({
                url: "/seminar/" + seminarId,
                type: "DELETE",
                success: function () {
                    alert("success");
                    window.location.href = "/teacher/courseInformation";

                },
                error: function () {
                    alert("failed");
                }

            })

        }

    })




    $(".body").on("click","#addTopic",function () {
        window.location.href = "/teacher/createTopic";
    })



    $(".body").on("click", "div[name=topic]", function () {
        var topicId = $(this).attr("id");
        localStorage.setItem("topicId", topicId);
        window.location.href = "/teacher/topicCheck";
    })

    
    $(".returnButton").click(function () {

        window.history.back();

    })



})