(function ($) {
	$("#formSubmit").submit(function(event) {
		event.preventDefault();
		submitForm();
	});
	
	function submitForm() {
		$("#submitButton").button("loading");
		var payload = {
			names : $("#names").val(),
			email : $("#email").val(),
			password : $("#password").val(),
			
			vegetarians : $("#vegetarians").val(),
			vegans : $("#vegans").val(),
			lactos : $("#lactos").val(),
			
			allergies : $("#allergies").val(),
			message : $("#message").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/Register/",
			data: payload,
			success : function() {
				$("#submitButton").button("reset");
				$("#sendmessage").show();
				$("#errormessage").removeClass("show");
				$("#formSubmit").hide();
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				$("#errormessage").addClass("show");
				$("#errormessage").text(XMLHttpRequest.responseText);
				$("#submitButton").button("reset");
			}
		});
	};
})(jQuery);