package org.nunstudy.pathology

class NunId {
	String autopId
	Integer aperioId
	String aperioCode

    static constraints = {
		autopId()
		aperioId()
		aperioCode()
    }
	
	static mapping = {
		table 'nun_ids'
		version false
		id generator:'assigned', column:'NunID', type: 'long', sqlType: 'int'

		autopId column:'AutopID'
		aperioId column:'AperioID'
		aperioCode column:'AperioCode'
	}
	
	static transients = [ 'blocks' ]
	
	def getBlocks() {
		def nunInstance = Nun.read(id)
		if (nunInstance) {
			return nunInstance?.blocks.sort { a, b -> a.label <=> b.label }			
		}
		return null
	}

}
