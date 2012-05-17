package org.nunstudy.pathology

class Hemisphere {
	Integer code
	String name
		
	String toString() { name }
	
    static constraints = {
		code()
		name()
    }
	
	static mapping = {
		table 'hemisphere_decode'
		version false
		id column:'Hemisphere', type: 'string', sqlType: 'char'

		code column:'HemisphereCode', type: 'int', sqlType: 'tinyint'
		name column:'HemisphereName'
	}
}
