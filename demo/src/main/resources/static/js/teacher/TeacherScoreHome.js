$(function () {

    var seminarId = localStorage.getItem("seminarId");

    console.log(seminarId);



    var courseJson = localStorage.getItem("courseJson");
    courseJson = JSON.parse(courseJson);
    $(".courseName").text(courseJson.name);
    $(".courseIntroduction").text(courseJson.description);


    $.ajax({
        url:"/seminar/"+seminarId+"/group",
        type: "GET",
        success: function (data) {
            console.log(data);
            if (data.length != undefined) {
                for (var i = 0; i < data.length; i++) {
                    $(".tableContent").append("  <tr>\n" +
                        "                    <td>" + data[i].name[1] + "</td>\n" +
                        "                    <td>" + data[i].name + "</td>\n" +
                        "                    <td>XXX</td>\n" +
                        "                    <td>5</td>\n" +
                        "                    <td>已提交</td>\n" +
                        "                    <td>5</td>\n" +
                        "                    <td>5</td>\n" +
                        "                    <td>\n" +
                        "                         <img src=\"/img/view.png\" alt=\"预览\" name='report' id=" + data[i].id + ">\n" +
                        "                        <img src=\"/img/download.png\" alt=\"下载\" name='download' id=" + data[i].id + ">\n" +
                        "                    </td>\n" +
                        "                </tr>")
                }
            }
        }

    })


    $(".body").on("click", "[name=report]", function () {
        var groupId = $(this).attr("id");
        localStorage.setItem("groupId", groupId);
        window.location.href = "/teacher/scoreReport";

    })


    $(".body").on("click", "[name=download]", function () {
        var groupId = $(this).attr("id");
        console.log(groupId);
        //download??

    })
/*
    $(".returnButton").click(function () {

        window.history.back();

    })*/

})