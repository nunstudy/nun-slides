package org.nunstudy.pathology

class AperioNun {

	String autopId
	Integer blocks
	Integer stains
	Integer aperio

	static constraints = {
		autopId()
		blocks(nullable:true)
		stains(nullable:true)
		aperio(nullable:true)
	}

	static mapping = {
		table 'aperio_nun_table'
		version false
		id column:'AperioID', type: 'long', sqlType: 'int'

		autopId column:'AutopID'
		blocks column:'Blocks'
		stains column:'Stains'
		aperio column:'Aperio'
	}
}
