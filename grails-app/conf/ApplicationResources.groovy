modules = {
    application {
        resource url:'js/application.js'
    }
	
	nunSlides {
		dependsOn 'jquery'
		dependsOn 'jquery-ui'
		resource url:'js/nun-slides.js'		
	}
}