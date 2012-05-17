package org.nunstudy.pathology

class StainTemplate {
	
	static belongsTo = [ blockTemplate: BlockTemplate, stainType: StainType ]

    static constraints = {
    }
		
	static mapping = {
		version false
		id column:'StainDefaultID', type: 'long', sqlType: 'int'

		blockTemplate column:'BlockDefaultID', type: 'long', sqlType: 'int'
		stainType column:'StainTypeID', type: 'long', sqlType: 'int'
    }
}
