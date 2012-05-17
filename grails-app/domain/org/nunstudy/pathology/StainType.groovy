package org.nunstudy.pathology

class StainType {
	String description
	String abbreviation
	String dataAbbreviation
	String aperioName
	Integer sortOrder
	
	String appCreated = 'nun-slides'
	Date dateCreated = new Date()
	String userCreated
	
	String toString() { description }
	
    static constraints = {
		description()
		abbreviation()
		dataAbbreviation()
		aperioName()
		appCreated()
		dateCreated()
		userCreated()
		sortOrder nullable: true
    }
	
	static mapping  = {
		table 'stain_types'
		version false
		id column:'StainTypeID', type: 'long', sqlType: 'int'
		
		description column:'StainTypeDesc'
		abbreviation column:'StainTypeAbbrev'
		dataAbbreviation column:'StainDataAbbrev'
		aperioName column:'AperioName'
		dateCreated column:'CreateDate'
		userCreated column:'CreateUser'
		appCreated column:'CreateApp'
	}

}
