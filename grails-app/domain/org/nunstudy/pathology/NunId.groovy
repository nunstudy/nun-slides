package org.nunstudy.pathology

class NunId implements Serializable {
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
		id column:'NunID', type: 'long', sqlType: 'int'

		autopId column:'AutopID'
		aperioId column:'AperioID'
		aperioCode column:'AperioCode'
	}

}
