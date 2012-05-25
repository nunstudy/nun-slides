package org.nunstudy.pathology

import org.joda.time.*

class AperioService {

    def serviceMethod() {

    }
	
	def scanStatus(Integer status) {
		if (status) {
			if (status == 1) {
				return "No data"
			}
			if (status == 2) {
				return "Done"
			}
			if (status == 3) {
				return "To do"
			}
			if (status == 4) {
				return "Started"
			}
		}
		return null		
	}
	
	def parseYear(String autopId) {
		/**
		 * Impute the autopsy year from
		 * the Autopsy ID string. 
		 */
		def autopYear = null
		if (autopId) {
			def autopElementList = autopId.split('-')
			
			// NOTE: The parse year logic will become invalid in 2099
			def daysRemaining = daysUntilParseYearBreaks()
			if (daysRemaining > 0 && daysRemaining < 365) {
				log.warn "The parseYear logic will be invalid in $daysRemaining days"
			}
			if (daysRemaining <= 0) {
				log.error "The parseYear logic is invalid!"
			}
			
			if (autopElementList) {
				try {
					// Get the end of the string
					autopYear = autopElementList[2]
				} catch (Exception e) {
					log.warn "year could not be found in autopId::$autopid::$e"
					return null
				}
				// Prepend 19 or 20 to year depending on last two digits
				// Ensure that we have two digits
				if (autopYear && autopYear ==~ /\d{2}/) {
					if (autopYear ==~ /^[9]\d*/) {
						autopYear = "19$autopYear"
					} else {
						autopYear = "20$autopYear"
					}
				}
			}
		}
		return autopYear
	}
	
	def parseSequenceId(String autopId) {
		/**
		 * Impute the autopsy sequence id from
		 * the Autopsy ID string.
		 */
		def sequenceId = null
		if (autopId) {
				
			def autopElementList = autopId.split('-')
					
			if (autopElementList) {
				try {
					// Get the end of the string
					sequenceId = autopElementList[1]
				} catch (Exception e) {
					log.warn "sequence could not be found in autopId::$autopid::$e"
					return null
				}
				// Ensure that we have digits
				if (sequenceId && sequenceId ==~ /\d+/) {
					return sequenceId
				} else {
					sequenceId = null
				}
			}
		}
		return sequenceId
	}
	
	def daysUntilParseYearBreaks() {
		DateTime startDate = new DateTime()
		DateTime endDate = new DateTime('2099-1-1')
		
		return Days.daysBetween(startDate,endDate).getDays()
	}
}
