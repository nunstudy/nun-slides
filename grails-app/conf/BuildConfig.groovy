grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
		grailsRepo "http://svn.cccs.umn.edu/grails-plugins"
		mavenRepo "http://artifact.ncs.umn.edu/plugins-release"

    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

		runtime 'net.sourceforge.jtds:jtds:1.2.4'
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"
        runtime ":zipped-resources:1.0"
        runtime ":cached-resources:1.0"
		runtime ":raphael:2.0.2"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"

		build ":spock:0.6-SNAPSHOT"
		compile ":umn-web-template:0.2.3"
		compile ":spring-security-core:1.2.7.9"
		compile ":spring-security-ldap:1.0.5.1"
		compile ":spring-security-mock:1.0.1"
		compile ":spring-security-shibboleth-native-sp:1.0.3"
		compile ":cache-headers:1.0.4"
    }
}
