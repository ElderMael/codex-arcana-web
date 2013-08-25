$(document).ready(function() {

	NProgress.done(true);

	$(document).ajaxSend(function(event, request, settings) {
		NProgress.start();
	});

	$(document).ajaxStop(function() {
		NProgress.done(true);
	});

	$('#loadNews').on('click', function(event) {

		console.log('Loading news...');

		$.ajax({
			url : '/blog-web/news',
			type : 'GET',
			dataType : 'json',
			success : function(response) {
				console.log(response);
				for ( var i = 0; i < response.entries.length; i++) {
					$('#news').append('<p>' + response.entries[0].content  + '</p>');
				}
			}
		});

	});

});