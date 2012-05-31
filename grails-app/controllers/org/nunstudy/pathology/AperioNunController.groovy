package org.nunstudy.pathology

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.cache.CacheEvict
import grails.plugin.cache.Cacheable

class AperioNunController {
	def nunIdService
	def debug = true
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

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

	@CacheEvict("aperioNunListCache")
	def refreshList() {
		redirect(action: "list")		
	}
	
    def create() {
        [aperioNunInstance: new AperioNun(params)]
    }

    def save() {
        def aperioNunInstance = new AperioNun(params)
        if (!aperioNunInstance.save(flush: true)) {
            render(view: "create", model: [aperioNunInstance: aperioNunInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'aperioNun.label', default: 'AperioNun'), aperioNunInstance.id])
        redirect(action: "show", id: aperioNunInstance.id)
    }

    def show() {
        def aperioNunInstance = AperioNun.get(params.id)
        if (!aperioNunInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'aperioNun.label', default: 'AperioNun'), params.id])
            redirect(action: "list")
            return
        }

        [aperioNunInstance: aperioNunInstance]
    }

    def edit() {
        def aperioNunInstance = AperioNun.get(params.id)
        if (!aperioNunInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'aperioNun.label', default: 'AperioNun'), params.id])
            redirect(action: "list")
            return
        }

        [aperioNunInstance: aperioNunInstance]
    }

    def update() {
        def aperioNunInstance = AperioNun.get(params.id)
        if (!aperioNunInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'aperioNun.label', default: 'AperioNun'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (aperioNunInstance.version > version) {
                aperioNunInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'aperioNun.label', default: 'AperioNun')] as Object[],
                          "Another user has updated this AperioNun while you were editing")
                render(view: "edit", model: [aperioNunInstance: aperioNunInstance])
                return
            }
        }

        aperioNunInstance.properties = params

        if (!aperioNunInstance.save(flush: true)) {
            render(view: "edit", model: [aperioNunInstance: aperioNunInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'aperioNun.label', default: 'AperioNun'), aperioNunInstance.id])
        redirect(action: "show", id: aperioNunInstance.id)
    }

    def delete() {
        def aperioNunInstance = AperioNun.get(params.id)
        if (!aperioNunInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'aperioNun.label', default: 'AperioNun'), params.id])
            redirect(action: "list")
            return
        }

        try {
            aperioNunInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'aperioNun.label', default: 'AperioNun'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'aperioNun.label', default: 'AperioNun'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
