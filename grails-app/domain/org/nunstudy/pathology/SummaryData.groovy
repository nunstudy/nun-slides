package org.nunstudy.pathology

class SummaryData {
	Integer subjects
	Integer needBrain
	Integer noData
	Integer zeroScanned
	Integer someScanned
	Integer allScanned
	
    static constraints = {
    }

	static mapping = {
		table 'slide_counts'
		version false
		cache usage: 'read-only'		
		id generator:'assigned', column:'Subjects', type: 'long', sqlType: 'int', updateable: false, inserteable: false

		needBrain column:'needBrain'
		noData column:'noData'
		zeroScanned column:'zeroScanned'
		someScanned column:'someScanned'
		allScanned column:'allScanned'
	}
}
