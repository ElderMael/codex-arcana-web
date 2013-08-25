$(document).ready(function() {

	NProgress.done(true);

	$(document).ajaxSend(function(event, request, settings) {
		NProgress.start();
	});

	$(document).ajaxStop(function() {
		NProgress.done(true);
	});

	(function pollNews() {
		console.log('Loading news...');

		$.ajax({
			url : '/blog-web/news',
			type : 'GET',
			dataType : 'json',
			timeout : 2000,
			success : function(response) {
				console.log(response);
				$.each(response.entries, function(i, item) {
					$('#news').append('<p>' + item.content + '</p>');
				});
			},
			error : function() {
				console.log('Error retrieving news.');
			},
			complete : setTimeout(function() {pollNews()}, 5000)
		});
	})();

});