$(function () {

    $.ajax({
        url:"/course",
        type:"GET",
        success:function (data) {
            console.log(data);
            if(data.length != undefined){
                for(var i=0;i<data.length;i++){
                    $(".content").append("<div class=\"main_box_right_content\" id="+data[i].id+">\n" +
                        "            <h3 class=\"classtitle\">"+data[i].name+"\n" +
                        "                <button id='deleteCourse'>删除课程</button>\n" +
                        "                <button id='modifyCourse'>修改课程</button>\n" +
                        "            </h3>\n" +                        "            <div class=\"divideline\"></div>\n" +
                        "            <div class=\"classinfo\">\n" +
                        "                <table class=\"table\">\n" +
                        "                    <tr>\n" +
                        "                        <td class=\"tabletext\">班级数："+data[i].numClass+"</td>\n" +
                        "                        <td class=\"tabletext\">学生人数："+data[i].numStudent+"</td>\n" +
                        "                    </tr>\n" +
                        "                    <tr>\n" +
                        "                        <td class=\"tabletext\">开始时间："+data[i].startTime+"</td>\n" +
                        "                        <td class=\"tabletext\">结束时间: "+data[i].endTime+"</td>\n" +
                        "                    </tr>\n" +
                        "                </table>\n" +
                        "            </div>\n" +
                        "        </div>")
               }

                $(".content").append(" <div class=\"main_box_right_content\" id='addCourse'>\n" +
                    "            <img class=\"addcourse\" src=\"/img/add.png\">\n" +
                    "\n" +
                    "        </div>")
            }
        }
    })


    $(".body").on("click","#modifyCourse",function () {
        var courseId = $(this).parent().parent().attr("id");
        console.log(courseId);
        localStorage.setItem("courseId",courseId);
        window.location.href = "/teacher/updateCourse";
    })


    $(".body").on("click","#deleteCourse",function () {
        var courseId = $(this).parent().parent().attr("id");
       if(confirm("确认删除该课程")){
            $.ajax({
                url:"/course/"+courseId,
                type:"DELETE",
                success:function () {
               /**/     $("#"+courseId).hide();
                },
                error:function () {
                    alert("delete failed!")
                }
            })
        }
    })

    $(".body").on("click",".classinfo",function () {
        var courseId = $(this).parent().attr("id");
        console.log(courseId);
        localStorage.setItem("courseId",courseId);
        window.location.href = "/teacher/courseInformation";
    })

    $(".body").on("click","#addCourse",function () {
       var courseId = $(this).parent().parent().attr("id");
        console.log(courseId);
        localStorage.setItem("courseId",courseId);
        window.location.href = "/teacher/createCourse";
    })


})