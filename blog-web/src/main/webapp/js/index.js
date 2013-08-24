$(document).ready(
		function() {

			NProgress.done(true);

			$(document).ajaxSend(function(event, request, settings) {
				NProgress.start();
			});

			$(document).ajaxStop(function() {
				NProgress.done(true);
			});

			$('#loadNews').on(
					'click',
	function() {
	$.ajax({
							url : '/blog-web/news',
							dataType : 'json',
							success : function(data) {
								for ( var i = 0; i < data.entries.length; i++) {
									$('#news').append(
											'<p>' + data.entries[i].content
													+ '</p>');
								}

							}
						});
					});

		});