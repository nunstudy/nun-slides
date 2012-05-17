package org.nunstudy.pathology

import spock.lang.*
import grails.plugin.spock.*
import grails.test.mixin.TestFor

@TestFor(AperioScannedSlide)
class AperioScannedSlideSpec extends UnitSpec {

    def "Create AperioScannedSlide"() {
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
		def stain = new Stain(type: type, block: block,
			stainCode: stainCode,
			userCreated: userCreated).save()
		mockDomain(AperioScannedSlide)
		
		when:
		new AperioScannedSlide(stain: stain, stainCode: stainCode, barcodeId: barcodeId, blockLabel: blockLabel, aperioStainType: aperioStainType).save()
		
		then:
		AperioScannedSlide.findByBarcodeId(barcodeId)
		
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
		barcodeId = '123456'
		blockLabel = 'Cerebellum'
		aperioStainType = 1
    }
	
}
