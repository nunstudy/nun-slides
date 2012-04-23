package org.nunstudy.pathology

class BlockTemplate {

	String label
	BlockArea blockArea
	SubArea subArea
	String areaOtherText
	Hemisphere hemisphere

    static constraints = {
		label()
		blockArea()
		subArea(nullable: true)
		areaOtherText(nullable: true)
		hemisphere(nullable: true)
    }
	static mapping = {
		version false
		id column:'BlockDefaultID'

		label column:'BlockLabel'
		blockArea column:'BlockAreaID'
		subArea column:'SubAreaID'
		areaOtherText column:'AreaOtherText'
		hemisphere column:'Hemisphere'
	}
}
