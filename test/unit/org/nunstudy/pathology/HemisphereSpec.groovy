package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(Hemisphere)
class HemisphereSpec extends UnitSpec {

    def "Create Hemisphere"() {
		setup:
		mockDomain(Hemisphere)
		
		when:
		new Hemisphere(code: code, name: name).save()
		
		then:
		Hemisphere.findByCode(code)
		
		where:		
		code = 1
		name = 'left'
    }
}
