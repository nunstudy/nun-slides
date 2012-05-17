package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(StainType)
class StainTypeSpec extends UnitSpec {

    def "Create StainType"() {
		setup:
		mockDomain(StainType)
		
		when:
		new StainType(description: description, 
			abbreviation: abbreviation, 
			dataAbbreviation: dataAbbreviation, 
			aperioName: aperioName,
			userCreated: userCreated).save()
		
		then:
		StainType.findByAbbreviation(abbreviation)
		
		where:
		description = "B-Amyloid"
		abbreviation = "BA"
		dataAbbreviation = "ba"
		aperioName = "B-Amyloid"
		userCreated = 'ast'

    }
}
