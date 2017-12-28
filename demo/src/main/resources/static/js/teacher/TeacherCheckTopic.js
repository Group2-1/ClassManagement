function string2date(str){

    return new Date(Date.parse(str.replace(/-/g,  "/")));

}

$(function () {

    var topicId = localStorage.getItem("topicId");
    var courseJson = localStorage.getItem("courseJson");
    if (courseJson != null) {
        courseJson = JSON.parse(courseJson);
        $(".courseName").text(courseJson.name);
        $(".courseIntroduction").text(courseJson.description);

    }

    //查询topic时间是否已经开始，进而决定按钮的隐藏与开启,
    var seminarJson = localStorage.getItem("seminarJson");
    if (seminarJson != null) {
        seminarJson = JSON.parse(seminarJson);
        console.log(seminarJson);
        var startTime = string2date(seminarJson.startTime);
        var nowData = new Date();
        if(startTime<nowData){
            //讨论课已开始
            $("#modify").hide();
            $("#delete").hide()
        }

    }


    //填充页面

    $.ajax({

        url:"/topic/"+topicId,
        type:"GET",
        success:function (data) {
            console.log(data);
            var json = JSON.stringify(data);
            localStorage.setItem("topicJson", json);
            
            $("#name").text(data.name);
            $("#desc").text(data.description);
            $("#groupLimit").text(data.groupLimit);
            $("#groupMemberLimit").text(data.groupMemberLimit);

            //查询多少小组选择了该topic

            $.ajax({
            	
                url:"/topic/"+topicId+"/group",
                type:"GET",
                success:function (data) {
                    if(data.length != undefined){
                       $("#groupChooseNum").text(data.length);
                    }
               }
            })
        }
    })


    //点击了话题修改
    $(".body").on("click","#modify",function () {
        window.location.href = "/teacher/updateTopic";
    })



    //点击了删除话题
    $(".body").on("click","#delete",function () {
        if(confirm("确定要删除该话题？")){
            $.ajax({
                url:"/topic/"+topicId,
                type:"DELETE",
                success:function () {
                    alert("success");
                   window.history.back();

                },
                error:function () {

                    alert("failed");

                }

            })

        }

    })
    
    
    $(".returnButton").click(function () {
        window.history.back();

    })

})