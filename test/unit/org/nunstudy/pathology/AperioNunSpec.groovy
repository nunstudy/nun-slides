package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(AperioNun)
class AperioNunSpec extends UnitSpec {

    def "Create AperioNun"() {
		setup:
		mockDomain(AperioNun)
		
		when:
		new AperioNun(autopId: autopId, blocks: blocks, stains: stains, aperio: aperio).save()
		
		then:
		AperioNun.findByAutopId(autopId)
		
		where:
		autopId = "JCASGL"
		blocks = 5 
		stains = 3
		aperio = 123456
    }
}
