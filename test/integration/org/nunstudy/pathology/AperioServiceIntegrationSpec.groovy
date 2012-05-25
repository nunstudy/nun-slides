package org.nunstudy.pathology

import grails.plugin.spock.IntegrationSpec

class AperioServiceIntegrationSpec extends IntegrationSpec {
	def aperioService
	def debug = true
	
	def "Test time until year parser breaks"() {
		
		when:
		def yearsToGo = aperioService.daysUntilParseYearBreaks()
		
		then:
		assert yearsToGo
		if (debug) {
			println "Only $yearsToGo days to go until parser breaks"
		}
			
	}
	
	def "Test year parser"() {
		
		when:
		def year = aperioService.parseYear(autopId)
		assert year
		def year2 = aperioService.parseYear(autopId2)
		assert year2
		def year3 = aperioService.parseYear(autopId3)
		assert year3
		def year4 = aperioService.parseYear(autopId4)
		assert year4
		def year5 = aperioService.parseYear(autopId5)
		assert year5

		then:
		year == parseYear
		if (debug) {
			println "AutopId $autopId -> $year"
		}
		year2 == parseYear2
		if (debug) {
			println "AutopId $autopId2 -> $year2"
		}
		year3 == parseYear3
		if (debug) {
			println "AutopId $autopId3 -> $year3"
		}
		year4 == parseYear4
		if (debug) {
			println "AutopId $autopId4 -> $year4"
		}
		year5 == parseYear5
		if (debug) {
			println "AutopId $autopId5 -> $year5"
		}

		where:		
		autopId = "N-1-99"
		parseYear = "1999"
		autopId2 = "N-1-97"
		parseYear2 = "1997"
		autopId3 = "N-10-90"
		parseYear3 = "1990"
		autopId4 = "N-1-00"
		parseYear4 = "2000"
		autopId5 = "N-12-09"
		parseYear5 = "2009"
		
	}
	
	def "Test parse sequence id"() {
		when:
		def sequenceId = aperioService.parseSequenceId(autopId)
		assert sequenceId
		def sequenceId2 = aperioService.parseSequenceId(autopId2)
		assert sequenceId2
		def sequenceId3 = aperioService.parseSequenceId(autopId3)

		then:
		sequenceId == parseSequenceId
		if (debug) {
			println "AutopId $autopId -> $sequenceId"
		}
		sequenceId2 == parseSequenceId2
		if (debug) {
			println "AutopId $autopId2 -> $sequenceId2"
		}
		!sequenceId3 		// This should be null
		if (debug) {
			println "AutopId $autopId3 -> $sequenceId3"
		}

		where:
		autopId = "N-1-99"
		parseSequenceId = "1"
		autopId2 = "N-01-97"
		parseSequenceId2 = "01"
		autopId3 = "N-Z-90"
		parseSequenceId3 = null

	}
	
	def "Test scanned status"() {
		when:
		def status = aperioService.scanStatus(stat)
		
		then:
		status == output
		
		where:
		
		stat | output
		1 | "No data"
		2 | "Done"
		3 | "To do"
		4 | "Started"
	}
}
