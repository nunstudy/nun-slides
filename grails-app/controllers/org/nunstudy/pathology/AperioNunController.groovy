package org.nunstudy.pathology

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_NUNSTUDY_ADMINISTRATIVE', 'ROLE_NUNSTUDY'])
class AperioNunController {
	def nunIdService
	def aperioService
	def debug = false
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 1000, 1000)
        //params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def summaryDataInstanceList = SummaryData.list()
		def summaryDataInstance = summaryDataInstanceList[0]
		
        [aperioNunInstanceList: AperioNun.list(params), aperioNunInstanceTotal: AperioNun.count(), summaryDataInstance: summaryDataInstance ]
    }

	def runSyncWithAperio() {
		def status = aperioService.syncWithAperio()
		if (status) {
			render "Sync with Aperio was successful!"			
		} else {
			render "Oops, the Sync with Aperio failed! Please send a message to help@cccs.umn.edu"		
		}
	}
}
