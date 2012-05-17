package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(Nun)
class NunSpec extends UnitSpec {

    def "Create Nun"() {
		setup:
		mockDomain(Nun)
		
		when:
		new Nun(lastName: lastName).save()
		
		then:
		Nun.findByLastName(lastName)
		
		where:		
		lastName = 'Doe'
    }
}
