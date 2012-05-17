package org.nunstudy.pathology

class AperioScannedSlide {
	String stainCode
	String barcodeId
	String blockLabel
	Integer aperioStainType

	static belongsTo = [ stain: Stain ]
		
	String toString() { "edu.umn.healthstudies.db.nunstudy.AperioScannedSlides[aperioID=$id]" }

	static constraints = {
		stain()
		stainCode()
		barcodeId(nullable:true)
		blockLabel()
		aperioStainType()
	}

	static mapping  = {
		table 'aperio_scanned_slides'
		version false
		id column:'AperioID', type: 'long', sqlType: 'int'
		
		stain column:'StainID', type: 'long', sqlType: 'int'
		stainCode column:'StainCode'
		barcodeId column:'BarcodeID'
		blockLabel column:'BlockLabel'
		aperioStainType column:'AperioStainType'
    }
}
