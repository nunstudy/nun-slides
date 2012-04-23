package org.nunstudy.pathology

class AperioScannedSlides {

	Stain stain
	String stainCode
	String barcodeId
	String blockLabel
	Integer aperioStainType

    static constraints = {
		version false
		id generator: 'assigned', column:'AperioID', type: 'long', sqlType: 'int'

		stain()
		stainCode()
		barcodeId(nullable:true)
		blockLabel()
		aperioStainType()
    }
}
