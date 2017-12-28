function getSeminarInfo(){
    var seminarId = localStorage.getItem("seminarId");
    //填充信息
    var seminarJson = localStorage.getItem("seminarJson");
    if (seminarJson != null) {
        seminarJson = JSON.parse(seminarJson);
        console.log(seminarJson);
        $("input[name=seminarName]").val(seminarJson.name);
        $("#description").val(seminarJson.description);
        $("#groupingMethod").val((seminarJson.groupingMethod == "fixed" ? 0 : 1));
        $("input[name=startTime]").val(seminarJson.startTime);
        $("input[name=endTime]").val(seminarJson.endTime);
        $("input[name=presentationGrade]").val(seminarJson.presentationGrade);
        $("input[name=reportGrade]").val(seminarJson.reportGrade);
        $("input[name=c]").val(seminarJson.c);
        $("input[name=b]").val(seminarJson.b);
        $("input[name=a]").val(seminarJson.a);
    }
	
}


$(function () {
    var courseId = localStorage.getItem("courseId");
    var courseJson = localStorage.getItem("courseJson");
    courseJson = JSON.parse(courseJson);
    $(".courseName").text(courseJson.name);
    $(".courseIntroduction").text(courseJson.description);

    getSeminarInfo();
    
    $("#submit").click(function () {
        var model = $("select[class=bigSelect]").find("option:selected").text();
        if (model == "固定分组") {
            var pmodel = "fixed";
        } else {
            var pmodel = "random";
        }
        var proportions1 = {
            report: $("input[name=reportGrade]").val(),
            presentation: $("input[name=presentationGrade]").val(),
            c: $("input[name=c]").val(),
            b: $("input[name=b]").val(),
            a: $("input[name=a]").val(),
        }
        var seminarInfo = {
            name: $("input[name=seminarName]").val(),
            description: $("#description").val(),
            groupingMethod: pmodel,
            startTime: $("input[name=startTime]").val(),
            endTime: $("input[name=endTime]").val(),
            proportions: proportions1,
        }
        console.log(seminarInfo);

        $.ajax({
            url: "/seminar/" + seminarId,
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(seminarInfo),
            success: function (data) {
                alert("创建成功!");
                window.location.href = "/teacher/courseInformation";
            },
            error:function () {
                alert("创建错误");
            }
        })
    })

    $("#reset").click(function () {
    	getSeminarInfo();
       /* $("input[name=seminarName]").val("");
        $("#description").val("");
        $("input[name=startTime]").val("");
        $("input[name=endTime]").val("");
        $("input[name=reportGrade]").val("");
        $("input[name=presentationGrade]").val("");
        $("input[name=c]").val("");
        $("input[name=b]").val("");
        $("input[name=a]").val("");*/
    })
    
        $(".returnButton").click(function () {
        window.location.href = "/teacher/courseInformation";
    })
})