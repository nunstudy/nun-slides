package org.nunstudy.pathology

class BlockTemplate {

	String label
	BlockArea blockArea
	SubArea subArea
	String areaOtherText
	Hemisphere hemisphere

	static hasMany = [ stainTemplates: StainTemplate ]

	String toString() { label }
		
    static constraints = {
		label()
		blockArea()
		subArea(nullable: true)
		areaOtherText(nullable: true)
		hemisphere(nullable: true)
    }

	static mapping = {
		version false
		id column:'BlockDefaultID', type: 'long', sqlType: 'int'

		label column:'BlockLabel'
		blockArea column:'BlockAreaID', type: 'long', sqlType: 'int'
		subArea column:'SubAreaID', type: 'string', sqlType: 'varchar'
		areaOtherText column:'AreaOtherText'
		hemisphere column:'Hemisphere', type: 'string', sqlType: 'char'
	}
}
