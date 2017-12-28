(function () {

    $.ajax({				/////微信接口
        url: "http://apis.map.qq.com/ws/district/v1/list?key=7DFBZ-K4PWQ-TYK5Y-GL7XN-RBDSQ-XSB6M&output=jsonp",
        type: "GET",
        dataType: "JSONP",
        success: function (data) {
            console.log(data);
            var result = data.result[0];
            for(var i = 0;i<result.length;i++)
                $("#province").append(
                    "<option value=\"" + result[i].name + "\" id=\"" + result[i].id + "\">" + result[i].name + "</option>"
                );
            
            $.ajax({
                url: "http://apis.map.qq.com/ws/district/v1/getchildren?key=7DFBZ-K4PWQ-TYK5Y-GL7XN-RBDSQ-XSB6M&output=jsonp&id=" + $("#province option:selected").attr("id"),
                type: "GET",
                dataType: "JSONP",
                success: function (data) {
                    var result = data.result[0];
                    for(var i = 0;i<result.length;i++)
                        $("#city").append(
                            "<option value=\"" + result[i].name + "\" id=\"" + result[i].id + "\">" + result[i].name + "</option>"
                        );
                }
            });
        }

    });



    $("#province").change(function () {
    	//清空原来的city
        $("#city").empty();
        $.ajax({
            url: "http://apis.map.qq.com/ws/district/v1/getchildren?key=7DFBZ-K4PWQ-TYK5Y-GL7XN-RBDSQ-XSB6M&output=jsonp&id=" + $("#province option:selected").attr("id"),
            type: "GET",
            dataType: "JSONP",
            success: function (data) {
                var result = data.result[0];
                for(var i = 0;i<result.length;i++)
                    $("#city").append(
                        "<option value=\"" + result[i].name + "\" id=\"" + result[i].id + "\">" + result[i].name + "</option>"
                    );
            }
        });

    })

    $("#city").change(function(){
    	 //清除原来的school
 	   $("#school").empty();
 	   var city = $("#city option:selected").attr("value");    	
        $.ajax({        	
            url: "/school?city=" + city,
            type: "GET",
            success: function (data) {
            	alert("school");
                for(var i = 0;i<data.length;i++)
                    $("#school").append(
                        "<option value=\"" + data[i].name + "\">" + data[i].name + "</option>"
                    );
            }
        });    	
    	
    });
    
    var province = localStorage.getItem("province");
    var city = localStorage.getItem("city");
    var school = localStorage.getItem("school");
    $("#province option[value=province]").attr("selected",true);
    $("#city option[value=city]").attr("selected",true);
    $("#school option[value=school]").attr("selected",true);
       
    $("#submit").on("click", function() {
        
    	localStorage.setItem("userType","teacher");
    	
        teacherInfo = {     		
            name: $("#name").val(),
            phone: $("#phoneNum").val(),
            password: $("#password").val(),
            gender: $("input[name=gender]:checked").val() == "" ? "male" : "female",
            number: $("#stuffNum").val(),
            email: $("#eMail").val(),
            school: {
                province: $("#province option:selected").attr("value"),
                city: $("#city option:selected").attr("value"),
                name: $("#school option:selected").attr("value")
            }
        };
        
        $.ajax({
            url: "/me",
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(teacherInfo),
            success: function () {
                alert("bind successful!");
                window.location.href = "/teacher/home";
            }
        });
    });

    $("#createSchool").click(function () {
    	
       window.location.href = "/teacher/createSchool";
    });

})();
