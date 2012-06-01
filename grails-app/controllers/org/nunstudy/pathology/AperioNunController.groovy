package org.nunstudy.pathology

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.cache.Cacheable
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_NUNSTUDY_ADMINISTRATIVE', 'ROLE_NUNSTUDY'])
class AperioNunController {
	def nunIdService
	def debug = true
	
    def index() {
        redirect(action: "list", params: params)
    }

	@Cacheable("aperioNunListCache")
    def list() {
        params.max = Math.min(params.max ? params.int('max') : 1000, 1000)
		def summaryDataInstanceList = SummaryData.list()
		def summaryDataInstance = summaryDataInstanceList[0]
		
        [aperioNunInstanceList: AperioNun.list(params), aperioNunInstanceTotal: AperioNun.count(), summaryDataInstance: summaryDataInstance ]
    }

	
}
