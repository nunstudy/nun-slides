package org.nunstudy.pathology

class PresenceLevel {
	String description
	
    static constraints = {
		description()
    }
	
	static mapping = {
		version false
		id column:'PresenceLevel', type: 'int', sqlType: 'tinyint'

		description column:'Presence'		
	}

}
