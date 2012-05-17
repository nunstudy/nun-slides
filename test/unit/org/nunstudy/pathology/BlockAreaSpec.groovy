package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(BlockArea)
class BlockAreaSpec extends UnitSpec {

    def "Create BlockArea"() {
		setup:
		mockDomain(BlockArea)
		
		when:
		new BlockArea(description: description,
			abbreviation: abbreviation,
			original: original,
			allowHemisphere: allowHemisphere,
			userCreated: userCreated ).save()
		
		then:
		BlockArea.findByAbbreviation(abbreviation)
		
		where:		
		description = 'Fronal Pole'
		abbreviation= 'FP'
		original = true
		allowHemisphere = true
		userCreated = 'ast'
    }
}
