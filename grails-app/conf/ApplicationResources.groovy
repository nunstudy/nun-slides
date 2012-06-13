modules = {
    application {
        resource url:'js/application.js'
    }
	
	nunSlides {
		dependsOn 'jquery'
		dependsOn 'jquery-ui'
		resource url:'js/jquery.tablesorter.min.js'		
		resource url:'js/jquery.tablesorter.pager.js'		
		resource url:'css/themes/blue/style.css'		
		resource url:'css/jquery.tablesorter.pager.css'		
		resource url:'css/nun-slides.css'		
		resource url:'js/nun-slides.js'		
	}
}