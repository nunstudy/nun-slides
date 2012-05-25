package org.nunstudy.pathology

class NunIdService {

    def findNunId(String searchStr) {
		/**
		 * Takes a search string and attempts to
		 * find an associated Nun Id. Assumes
		 * it is an Aperio ID:Integer or 
		 * an Autopsy ID:String.
		 */
		// Try to find the Nun Id by AperioID
		def nunIdInstance = null
		if (searchStr) {
			try {
				nunIdInstance = NunId.findByAperioId(searchStr.toLong())
			} catch (Exception ex) {
				nunIdInstance = null
			}
			// Try by Autopsy ID
			if (!nunIdInstance) {
				nunIdInstance = NunId.findByAutopId(searchStr)				
			}			
		}
		return nunIdInstance
    }
	
	def scanningStatistics() {
		/**
		 * Statistics on scanning status
		 * of Subjects. Returns a map
		 */
		def results = [:]
		def brainsOutstanding = Nun.list().size() - NunId.list().size()
		results[brainsOutstanding] = brainsOutstanding
		
		
		return results
	}
	
}
