package org.nunstudy.pathology

class AperioNun implements Serializable {

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
		table 'aperio_nun'
		version false
		id column:'AperioID', type: 'long', sqlType: 'int'

		autopId column:'AutopID'
		blocks column:'Blocks', inserteable: false, updateable: false
		stains column:'Stains', inserteable: false, updateable: false
		aperio column:'Aperio', inserteable: false, updateable: false
		autopYear column:'AutopsyYear', inserteable: false, updateable: false
		autopOrder column:'AutopsyOrder', inserteable: false, updateable: false
	}
	
	static transients = [ 'status' ]
	
	Integer getStatus() {
		def status = null
		if (stains == aperio) {
			if (stains == 0) {
				status = 1		// No Data
			} else {
				status = 2		// Done
			}
		}
		if (stains > aperio) {
			if (aperio == 0) {
				status = 3 // To do
			} else {			
				status = 4		// Started
			}
		}
		return status
	}
}
