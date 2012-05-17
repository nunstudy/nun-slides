package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(Block)
class BlockSpec extends UnitSpec {

    def "Create Block"() {
		setup:
		mockDomain(Nun)
		def nun = new Nun(lastName: lastName).save()
		mockDomain(BlockArea)
		def blockArea = new BlockArea(description: description,
			abbreviation: abbreviation,
			original: original,
			allowHemisphere: allowHemisphere,
			userCreated: userCreated ).save()
		mockDomain(Block)
			
		when:
		new Block(nun: nun, blockArea: blockArea, userCreated: userCreated, slideSourceId: slideSourceId, label: label).save()
		
		then:
		Block.findByLabel(label)
		
		where:
		lastName = 'Doe'
		description = 'Fronal Pole'
		abbreviation= 'FP'
		original = true
		allowHemisphere = true
		userCreated = 'ast'
		slideSourceId = 400
		label = 'A' 

	}
}
