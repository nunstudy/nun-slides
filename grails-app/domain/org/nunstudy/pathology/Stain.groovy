package org.nunstudy.pathology

class Stain {
	String stainCode
	Date dateDeleted
	PresenceLevel neuronalLoss
	PresenceLevel lewyBodies
	PresenceLevel cellLoss
	PresenceLevel gliosis
	StainType type
	
	
	String appCreated = 'nun-slides'
	String appUpdated = 'nun-slides'
	Date dateCreated = new Date()
	Date lastUpdated
	String userCreated
	String userUpdated

	static belongsTo = [ block: Block ]
	
	static hasMany = [ aperioScannedSlides: AperioScannedSlide ]
		
    static constraints = {
		stainCode()
		type()
		dateDeleted nullable: true
		neuronalLoss nullable: true
		lewyBodies nullable: true
		cellLoss nullable: true
		gliosis nullable: true
		appCreated()
		appUpdated nullable: true
		dateCreated()
		lastUpdated nullable: true
		userCreated()
		userUpdated nullable: true
    }
	
	static mapping = {
		table 'stains'
		version false
		id column:'StainID', type: 'long', sqlType: 'int'

		block column:'BlockID', type: 'long', sqlType: 'int'
		stainCode column:'StainCode'
		type column:'StainTypeID', type: 'long', sqlType: 'int'
		dateDeleted column:'DeleteDate'
		neuronalLoss column:'NeuronalLoss', type: 'int', sqlType: 'tinyint'
		lewyBodies column:'LewyBodies', type: 'int', sqlType: 'tinyint'
		cellLoss column:'CellLoss', type: 'int', sqlType: 'tinyint'
		gliosis column:'Gliosis', type: 'int', sqlType: 'tinyint'
		appCreated column:'CreateApp'
		appUpdated column:'UpdateApp'
		dateCreated column:'CreateDate'
		lastUpdated column:'UpdateDate'
		userCreated column:'CreateUser'
		userUpdated column:'UpdateUser'
	}

}
