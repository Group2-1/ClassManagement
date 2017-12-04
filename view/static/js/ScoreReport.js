$(function(){
		/*加载pdf*/
/*
	$.ajax({
		url: "/group/{groupId}"
		type: 'GET',
		contentType: 'application/json',
		data: {
			"id": ,
			"name": ,
			"leader": {
				"id": ,
				"name":  },
			"report": 	
		}
		success:function(data){
			PDFObject.embed("test.pdf","#file");
		}
		error:{

		}

	});*/

		/*打分*/	
		$("#scoring").click(function(){
				
			$score = $("#score").val();
				
			if ($score<3 || $score>5) {
					
				alert("Error!\nplease enter the score in 3 to 5 points!");
				
			} else {
				/*$groupId = $

				$.ajax({
					url: "/group/{groupId}/grade",
					type: "PUT",
					contentType: 'application/json',
					data: { 
						"reportGrade": $score},
					success: function(date){
						window.location.href = "  ";
					}
*/
				};										
		});
});