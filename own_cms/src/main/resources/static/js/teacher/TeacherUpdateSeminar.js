function getInfo() {

    //获取seminar信息并填写

    var seminarJson = localStorage.getItem("seminarJson");

    if (seminarJson != null) {
        seminarJson = JSON.parse(seminarJson);
        console.log(seminarJson);
        $("input[name=seminarName]").val(seminarJson.name);
        $("#desc").val(seminarJson.description);
        $("#groupingMethod").val((seminarJson.groupingMethod == "fixed" ? 0 : 1));
        $("input[name=startTime]").val(seminarJson.startTime);
        $("input[name=endTime]").val(seminarJson.endTime);
        
        $("input[name=reportGrade]").val(seminarJson.endTime);
        $("input[name=seminarGrade]").val(seminarJson.endTime);
		$("input[name=aGrade]").val(seminarJson.endTime);
		$("input[name=bGrade]").val(seminarJson.endTime);
		$("input[name=cGrade]").val(seminarJson.endTime);

    }

}

$(function () {
    var courseId = localStorage.getItem("courseId");
    var courseJson = localStorage.getItem("courseJson");
    if (courseJson != undefined) {
        courseJson = JSON.parse(courseJson);
        $(".courseName").text(courseJson.name);
        $(".courseIntroduction").text(courseJson.description);
    }
    getInfo();


    $(".submit").click(function () {
        var model = $("select[class=bigSelect]").find("option:selected").text();
        if (model == "固定分组") {
            var pmodel = "fixed";
        } else {
            var pmodel = "random";
        }

        var pproportions = {
            report: $("input[name=reportGrade]").val(),
            presentation: $("input[name=seminarGrade]").val(),
            c: $("input[name=cGrade]").val(),
            b: $("input[name=bGrade]").val(),
            a: $("input[name=aGrade]").val(),
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
            url: "/seminar/" + 1,
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(seminarInfo),
            success: function (data) {
                alert("success");
                window.location.href = "/teacher/seminarInfo";

            },

            error:function () {
             console.log("error");

            }

        })

    })

    $(".returnButton").click(function () {
       window.history.back();

    })


    $(".reset").click(function () {
       getInfo();

    })



})