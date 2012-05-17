package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(PresenceLevel)
class PresenceLevelSpec extends UnitSpec {

    def "Create PresenceLevel"() {
		setup:
		mockDomain(PresenceLevel)
		
		when:
		new PresenceLevel(description: description).save()
		
		then:
		PresenceLevel.findByDescription(description)
		
		where:
		description = 'severe'
	}
}
