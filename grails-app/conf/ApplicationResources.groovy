modules = {
    application {
        resource url:'js/application.js'
    }
	
	nunSlides {
		dependsOn 'jquery'
		resource url:'js/nun-slides.js'		
	}
}