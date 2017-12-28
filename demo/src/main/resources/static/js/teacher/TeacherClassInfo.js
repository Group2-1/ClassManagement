$(function () {

    var classId = localStorage.getItem("classId");
    console.log(classId);


    var courseJson = localStorage.getItem("courseJson");
    courseJson = JSON.parse(courseJson);
    $(".courseName").text(courseJson.name);
    $(".courseIntroduction").text(courseJson.description);


    $.ajax({
        url:"/class/"+classId,
        type: "GET",
        success: function (data) {
            console.log(data);
            $(".title").text(data.name);
            $("#className").text(data.name);
            $("#time").text(data.time);
            $("#site").text(data.site);
            $("#report").text(data.proportions.report);
            $("#presentation").text(data.proportions.presentation);
            $("#c").text(data.proportions.c);
            $("#b").text(data.proportions.b);
            $("#a").text(data.proportions.a);
            localStorage.setItem("classJson", JSON.stringify(data));

        }

    })

    $(".returnButton").click(function () {
        window.history.back();
    })

    $("#modify").click(function () {
       window.location.href = "/teacher/updateClass";
    })

    $("#delete").click(function () {

        if(confirm("are you sure to delete the course?")){
            $.ajax({
               url:"/class/"+classId,
                type:"DELETE",
                success:function () {
                    window.location.href ="/teacher/courseInformation";
                },
                error:function () {
                    console.log("delete failed");

                }

            })

        }

    })

})