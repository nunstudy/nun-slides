package org.nunstudy.pathology

class SubArea implements Serializable {
	String id
	String description
	String synonym
	
	String toString() { description }
	
    static constraints = {
		description()
		synonym nullable: true
    }
	
	static mapping  = {
		version false
		id generator: 'assigned', type: 'string'
		
		id column:'SubAreaID'
		description column:'SubArea'
		synonym column:'Synonym'
    }
}
