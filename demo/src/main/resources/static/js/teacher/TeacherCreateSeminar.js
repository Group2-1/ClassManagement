$(function () {

    var courseId = localStorage.getItem("courseId");
    var courseJson = localStorage.getItem("courseJson");
    courseJson = JSON.parse(courseJson);
    $(".courseName").text(courseJson.name);
    $(".courseIntroduction").text(courseJson.description);


/*
    $(".returnButton").click(function () {
        window.location.href = "/teacher/courseInformation";

    })*/


    $(".submit").click(function () {
        var model = $("select[class=bigSelect]").find("option:selected").text();
        if (model == "fixedGroup") {
            var pmodel = "fixed";
        } else {
            var pmodel = "random";
        }

        var pproportions = {
            report: $("input[name=reportGrade]").val(),
            presentation: $("input[name=presentationGrade]").val(),
            c: $("input[name=c]").val(),            b: $("input[name=b]").val(),
            a: $("input[name=a]").val(),
        }

        var seminarInfo = {
            name: $("input[name=seminarName]").val(),
            description: $("#desc").val(),
            groupingMethod: pmodel,
            startTime: $("input[name=startTime]").val(),
            endTime: $("input[name=endTime]").val(),
            proportions: pproportions,

        }

        console.log(seminarInfo);

        $.ajax({
            url: "/course/" + courseId + "/seminar",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(seminarInfo),
            success: function (data) {
                alert("create successfully!");
                window.location.href = "/teacher/courseInformation";
            },

            error:function () {
               console.log("error!");
           }
        })
    })


    $(".reset").click(function () {
       $("input[name=seminarName]").val("");
        $("#desc").val("");
        $("input[name=startTime]").val("");
        $("input[name=endTime]").val("");
        $("input[name=reportGrade]").val("");
        $("input[name=presentationGrade]").val("");
        $("input[name=c]").val("");
        $("input[name=b]").val("");
        $("input[name=a]").val("");
    })

})