package org.nunstudy.pathology

class Block {

	String code
	BlockArea blockArea
	SubArea subArea
	String areaOtherText
	Boolean lesion = false
	Boolean infarction = false
	Boolean missing = false
	Boolean demented = false
	Integer slideSourceId
	Hemisphere hemisphere
	String label

	Date dateDeleted
	Date dateCreated = new Date()
	String userCreated
	String appCreated = 'nun-slides'
	Date lastUpdated
	String userUpdated
	String appUpdated

	static belongsTo = [ nun: Nun  ]
		
	static hasMany = [ stains: Stain ]
	
	String toString() { 
		if (hemisphere && !hemisphere ==~ /Undefined/) {
			"${label}: ${hemisphere}, ${blockArea}" 
		} else {
			"${label}: ${blockArea}" 
		}
	}
	
    static constraints = {
		code(nullable:true)
		nun()
		blockArea()
		subArea(nullable: true)
		areaOtherText(nullable: true)
		lesion()
		infarction()
		missing()
		demented()
		slideSourceId()
		hemisphere(nullable: true)
		label()

		dateDeleted(nullable: true)
		dateCreated()
		userCreated(maxSize: 16)
		appCreated(maxSize: 50)
		lastUpdated(nullable: true)
		userUpdated(nullable: true, maxSize: 16)
		appUpdated(nullable: true, maxSize: 50)
    }
	static mapping = {
		table 'blocks'
		version false
		id column:'BlockID', type: 'long', sqlType: 'int'

		code column:'BlockCode', insertable: false, updateable: false
		nun column:'NunID', type: 'long', sqlType: 'int'
		blockArea column:'BlockAreaID', type: 'long', sqlType: 'int'
		subArea column:'SubAreaID', type: 'string', sqlType: 'varchar'
		areaOtherText column:'AreaOtherText'
		lesion column:'Lesion'
		infarction column:'Infarction'
		missing column:'Missing'
		demented column:'Demented'
		slideSourceId column:'SlideSourceID', type: 'int', sqlType: 'int'
		hemisphere column:'Hemisphere', type: 'string', sqlType: 'char'
		label column:'BlockLabel'
		dateDeleted column:'DeleteDate'
		dateCreated column:'CreateDate'
		userCreated column:'CreateUser'
		appCreated column:'CreateApp'
		lastUpdated column:'UpdateDate'
		userUpdated column:'UpdateUser'
		appUpdated column:'UpdateApp'
	}
}
