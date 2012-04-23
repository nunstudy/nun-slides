package org.nunstudy.pathology

class AperioNun {

	String autopId
	Integer blocks
	Integer stains
	Integer aperio
	Integer autopYear
	Integer autopOrder

	static constraints = {
		autopId()
		blocks(nullable:true)
		stains(nullable:true)
		aperio(nullable:true)
		autopYear(nullable:true)
		autopOrder(nullable:true)
	}

	static mapping = {
		version false
		id generator: 'assigned', column:'AperioID', type: 'long', sqlType: 'int'

		autopId column:'AutopID'
		blocks column:'Blocks'
		stains column:'Stains'
		aperio column:'Aperio'
		autopYear column:'AutopsyYear'
		autopOrder column:'AutopsyOrder'
	}
}
