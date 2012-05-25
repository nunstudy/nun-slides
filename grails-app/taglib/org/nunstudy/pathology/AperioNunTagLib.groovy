package org.nunstudy.pathology

class AperioNunTagLib {
	def aperioService
	
	def autopYear = { attrs, body ->
		// Get the autopsy year for a subject
		def autopYr = aperioService.parseYear(attrs.autopId)
		out << body() << (autopYr)
	}

	def sequenceId = { attrs, body ->
		// Get the autopsy sequence id for a subject
		def seqId = aperioService.parseSequenceId(attrs.autopId)
		out << body() << (seqId)
	}

	def scannedStatus = { attrs, body ->
		// Get the autopsy sequence id for a subject
		def status = aperioService.scanStatus(attrs.status)
		out << body() << (status)
	}

}
