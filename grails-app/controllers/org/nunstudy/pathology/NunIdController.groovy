package org.nunstudy.pathology

import org.springframework.dao.DataIntegrityViolationException

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_NUNSTUDY_ADMINISTRATIVE', 'ROLE_NUNSTUDY'])
class NunIdController {
	def nunIdService
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

	def find() {
		def nunIdInstance = nunIdService.findNunId(params.id)
		if (!nunIdInstance) {
			flash.message = "Oops, sorry. A subject could not be found with id $params.id"
			redirect(controller:"mainMenu")			
		} else {
            render(view: "edit", model: [nunIdInstance: nunIdInstance])
			//redirect(action: "show", id: nunIdInstance.id)
		}
	}
	
    def list() {
        [aperioNunInstanceList: AperioNun.list(), aperioNunInstanceTotal: AperioNun.count()]
    }

    def create() {
        [nunIdInstance: new NunId(params)]
    }

    def save() {
        def nunIdInstance = new NunId(params)
        if (!nunIdInstance.save(flush: true)) {
            render(view: "create", model: [nunIdInstance: nunIdInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'nunId.label', default: 'NunId'), nunIdInstance.id])
        redirect(action: "show", id: nunIdInstance.id)
    }

    def show() {
        def nunIdInstance = NunId.get(params.id)
        if (!nunIdInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'nunId.label', default: 'NunId'), params.id])
            redirect(action: "list")
            return
        }

        [nunIdInstance: nunIdInstance]
    }

    def edit() {
        def nunIdInstance = NunId.get(params.id)
        if (!nunIdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nunId.label', default: 'NunId'), params.id])
            redirect(action: "list")
            return
        }

        [nunIdInstance: nunIdInstance]
    }

    def update() {
        def nunIdInstance = NunId.get(params.id)
        if (!nunIdInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nunId.label', default: 'NunId'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (nunIdInstance.version > version) {
                nunIdInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'nunId.label', default: 'NunId')] as Object[],
                          "Another user has updated this NunId while you were editing")
                render(view: "edit", model: [nunIdInstance: nunIdInstance])
                return
            }
        }

        nunIdInstance.properties = params

        if (!nunIdInstance.save(flush: true)) {
            render(view: "edit", model: [nunIdInstance: nunIdInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'nunId.label', default: 'NunId'), nunIdInstance.id])
        redirect(action: "show", id: nunIdInstance.id)
    }

    def delete() {
        def nunIdInstance = NunId.get(params.id)
        if (!nunIdInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'nunId.label', default: 'NunId'), params.id])
            redirect(action: "list")
            return
        }

        try {
            nunIdInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'nunId.label', default: 'NunId'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'nunId.label', default: 'NunId'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
}
