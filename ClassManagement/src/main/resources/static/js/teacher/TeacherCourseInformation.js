$(function () {

    var courseId = localStorage.getItem("courseId");

    console.log(courseId);

    $.ajax({
        url:"/course/"+courseId,
        type: "GET",
        success: function (data) {
            console.log(data);
            var json = JSON.stringify(data);
            localStorage.setItem("courseJson", json)
               
            var courseJson = localStorage.getItem("courseJson");
            courseJson = JSON.parse(courseJson);
            $(".courseName").text(courseJson.name);
            $(".courseIntroduction").text(courseJson.description);
        }
    })


    $.ajax({
    	
        url:"/course/"+courseId+"/class",

        type: "GET",
        success: function (data) {
            console.log(data);
            if (data.length != undefined) {
               for (var i = 0; i < data.length; i++) {
                   $("#classContent").append("<div class=\"block\" id=" + data[i].id + " name='class'>\n" +
                        "                    <div class=\"blockFont\">" + data[i].name + "</div>\n" +
                        "                </div>")
                }
            }

            $("#classContent").append("              <div class=\"block\" id='addClass'>\n" +
                "                    <img class=\"addImg\" src=\"/img/smalladd.png\" alt=\"添加\">\n" +
                "                </div>")
        }
    })


    $.ajax({

        url:"/course/"+courseId+"/seminar",
        type: "GET",
        success: function (data) {
            console.log(data);
           if (data.length != undefined) {
                for (var i = 0; i < data.length; i++) {
                    $("#seminarContent").append("\n" +
                        "                <div class=\"block\" id=" + data[i].id + " name='seminar'>\n" +
                        "                    <div class=\"blockFont\">" + data[i].name + "</div>\n" +
                        "                </div>")
                }
            }

            $("#seminarContent").append(" <div class=\"block\" id='addSeminar'>\n" +
                "                    <img class=\"addImg\" src=\"/img/smalladd.png\" alt=\"添加\">\n" +
                "                </div>")
        }
    })


    $(".body").on("click", "#addClass", function () {
        window.location.href = "/teacher/createClass";
    })

    
    
    $(".body").on("click", "#addSeminar", function () {
        window.location.href = "/teacher/createSeminar";
    })

    /*$(".returnButton").click(function () {

        window.history.back();

    })*/

    $(".body").on("click", "div[name=class]", function () {
        var classId = $(this).attr("id");
        localStorage.setItem("classId", classId);
        window.location.href = "/teacher/classInfo";
    })



    $(".body").on("click", "div[name=seminar]", function () {
        var seminarId = $(this).attr("id");
        localStorage.setItem("seminarId", seminarId);
        window.location.href = "/teacher/seminarInfo";

    })

})