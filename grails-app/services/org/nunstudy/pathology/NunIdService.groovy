package org.nunstudy.pathology

import org.hibernate.cache.ReadWriteCache.Item;

class NunIdService {

    def findNunId(String searchStr) {
		/**
		 * Takes a search string and attempts to
		 * find an associated Nun Id. Assumes
		 * it is a Nun ID:Integer, Aperio ID:Integer or 
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
				nunIdInstance = NunId.findByAutopId(searchStr.toUpperCase())				
			}			
		}
		return nunIdInstance
    }
	
}
