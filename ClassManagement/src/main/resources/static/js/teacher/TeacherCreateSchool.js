(function () {

    $.ajax({
        url: "/school/province",
        type: "GET",
        success: function (data) {
            for(var i = 0;i<data.length;i++)
                $("#province").append(
                   "<option value=\"" + data[i] + "\">" + data[i] + "</option>"
                );

            
            $.ajax({
                url: "/school/city?province=" + $("#province option:selected").attr("value"),
                type: "GET",
                success: function (data) {
                    for(var i = 0;i<data.length;i++)
                        $("#city").append(
                            "<option value=\"" + data[i] + "\">" + data[i] + "</option>"
                        );
                }
            });
        }
    });

    

    $("#submit").on("click", function () {
        school = {
            name: $("#school").val(),
            province: $("#province option:selected").attr("value"),
            city: $("#city option:selected").attr("value")
        };

        $.ajax({
            url: "/school",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(school),
            success: function (data) {
                alert("create success");
           }
       })

    });

})();