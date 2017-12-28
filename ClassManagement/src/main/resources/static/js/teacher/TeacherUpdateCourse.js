var courseId = localStorage.getItem("courseId");

console.log(courseId);

function getInfo() {

    $.ajax({
       url:"/course/"+courseId,
       type:"GET",
        success:function (data) {
        	console.log(data);
           $("#coursename").val(data.name);
            $("#courseinfo").val(data.description);
        }
    })
}

$(function () {

    getInfo();
   $("#submit").click(function () {
        var course = {
            name: $("#coursename").val(),
            description: $("#courseinfo").val(),
            startTime: $("#begintime").val(),
            endTime: $("#endtime").val(),
            proportions: {
                report: $("#reportscore").val(),
                presentation: $("#seminarscore").val(),
                c: $("#three").val(),
                b: $("#four").val(),
                a: $("#five").val()
            }
        };

        $.ajax({
            url: "/course/" + courseId,
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(course),
            success: function (data) {
                alert("create success!");
                window.location.href = "/teacher/courseHome"
           }
        });
    });


    $("#reset").click(function () {
        $("input, textarea").val("");
    })

})