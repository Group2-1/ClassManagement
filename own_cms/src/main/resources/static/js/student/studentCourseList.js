$(document).ready(function() {
    $.ajax({
        url:'/course',
        type:'GET',
        dataType:'json',
        success:function (data) {
            var count=data.length;
            if(count!=0) {
                var grandparent = $('#courseList');
                for (var i = 0; i < count; i++) {
                    var parent = $(document.createElement('div'));
                    parent.addClass('main_box_right_content');
                    parent.append(
                        '<h3 class=\"classtitle\"><span id=\"name\" onclick=\"courseInfo('+data[i].id+')\">'+data[i].name+'</span><button>退选课程</button></h3>'
                    );
                    parent.append('<hr />');
                    var child = $(document.createElement('div'));
                    child.addClass('classinfo');
                    child.append(
                        '<span class=\"info\">班级数：' + data[i].numClass + '</span><br/>' +
                        '<span class=\"info\">学生人数：' + data[i].numStudent + '</span><br/>' +
                        '<span class=\"info\">开始时间：' + data[i].startTime + '</span><br/>' +
                        '<span class=\"info\">结束时间：' + data[i].endTime + '</span><br/>'
                    );
                    child.appendTo(parent);
                    parent.appendTo(grandparent);
                }
            }
        },
        error:function () {
            alert("无法获取课程列表");
        }
    });
});

function courseInfo(id) {
    window.location.href="/student/courseInformation";
}


/*
<div id="courseList">
    <div class="main_box_right_content">
        <h3 class="classtitle">
            <span>J2EE</span>
            <button>退选课程</button>
        </h3>
        <hr/>
        <div  class="classinfo">
            <span class="info" id="numClass">班级数：1</span><br/>
            <span class="info" id="numStudent">学生人数：60人</span><br/>
            <span class="info" id="StartTime">开始时间：1/9/2017</span><br/>
            <span class="info" id="EndTime">结束时间：1/1/2018</span><br/>
        </div>
    </div>

    <div class="main_box_right_content">
        <h3 class="classtitle">
            <span>J2EE</span>
            <button>退选课程</button>
        </h3>
        <hr/>
        <div  class="classinfo">
            <span class="info" id="numClass">班级数：1</span><br/>
            <span class="info" id="numStudent">学生人数：60人</span><br/>
            <span class="info" id="StartTime">开始时间：1/9/2017</span><br/>
            <span class="info" id="EndTime">结束时间：1/1/2018</span><br/>
        </div>
    </div>
</div>
 */