package org.nunstudy.pathology

class BlockArea {

	String description
	String abbreviation
	Boolean original = false
	Boolean allowHemisphere = false
	BlockArea childOfArea
	Date dateCreated = new Date()
	String userCreated
	String appCreated = 'nun-slides'
	Date lastUpdated
	String userUpdated
	String appUpdated

	String toString() { description }
	
	static constraints = {
		description(maxSize:50)
		abbreviation(maxSize:8)
		original()
		allowHemisphere()
		childOfArea(nullable: true)
		dateCreated()
		userCreated(maxSize: 16)
		appCreated(maxSize: 50)
		lastUpdated(nullable: true)
		userUpdated(nullable: true, maxSize: 16)
		appUpdated(nullable: true, maxSize: 50)
	}

	static mapping = {
		table 'block_areas'
		version false
		id column:'BlockAreaID', type: 'long', sqlType: 'int'

		description column:'BlockAreaDesc'
		abbreviation column:'BlockAreaAbbrev'
		allowHemisphere column:'AllowHemisphere'
		childOfArea column:'ChildOfAreaID', type: 'long', sqlType: 'int'
		dateCreated column:'CreateDate'
		userCreated column:'CreateUser'
		appCreated column:'CreateApp'
		lastUpdated column:'UpdateDate'
		userUpdated column:'UpdateUser'
		appUpdated column:'UpdateApp'
	}
}
