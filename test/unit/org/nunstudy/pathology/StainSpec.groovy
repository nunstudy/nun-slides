package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(Stain)
class StainSpec extends UnitSpec {

    def "Create Stain"() {
		setup:
		mockDomain(Nun)
		def nun = new Nun(lastName: lastName).save()
		mockDomain(BlockArea)
		def blockArea = new BlockArea(description: blockAreaDescription,
			abbreviation: blockAreaAbbreviation,
			original: original,
			allowHemisphere: allowHemisphere,
			userCreated: userCreated ).save()
		mockDomain(Block)
		def block = new Block(nun: nun, blockArea: blockArea, userCreated: userCreated, slideSourceId: slideSourceId, label: label).save()
		mockDomain(StainType)
		def type = new StainType(description: description, 
			abbreviation: abbreviation, 
			dataAbbreviation: dataAbbreviation, 
			aperioName: aperioName,
			userCreated: userCreated).save()
		mockDomain(Stain)
		
		when:
		new Stain(type: type, block: block,
			stainCode: stainCode,
			userCreated: userCreated).save()
		
		then:
		Stain.findByStainCode(stainCode)
		
		where:
		lastName = 'Doe'
		blockAreaDescription = 'Fronal Pole'
		blockAreaAbbreviation= 'FP'
		original = true
		allowHemisphere = true
		userCreated = 'ast'
		slideSourceId = 400
		label = 'A' 

		stainCode = 'ABC'
		description = "B-Amyloid"
		abbreviation = "BA"
		dataAbbreviation = "ba"
		aperioName = "B-Amyloid"
    }
}
