package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(SubArea)
class SubAreaSpec extends UnitSpec {

    def "Create SubArea"() {
		setup:
		mockDomain(SubArea)
		
		when:
		//new SubArea(subAreaId: subAreaId, description: description, synonym: synonym).save(flush: true, failOnError: true)
		def subArea = new SubArea(description: description, synonym: synonym)
		subArea.id = subAreaId
		subArea.save(flush: true, failOnError: true)
		
		then:
		SubArea.get(subAreaId)
		
		where:
		subAreaId = "Ant"
		description = 'Anterior'
		synonym = 'Front'
    }
}
