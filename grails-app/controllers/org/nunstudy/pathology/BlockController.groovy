package org.nunstudy.pathology

import org.springframework.dao.DataIntegrityViolationException

class BlockController {
	def debug = true
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [blockInstanceList: Block.list(params), blockInstanceTotal: Block.count()]
    }

    def create() {
        [blockInstance: new Block(params)]
    }

    def save() {
        def blockInstance = new Block(params)
        if (!blockInstance.save(flush: true)) {
            render(view: "create", model: [blockInstance: blockInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'block.label', default: 'Block'), blockInstance.id])
        redirect(action: "show", id: blockInstance.id)
    }

    def show() {
        def blockInstance = Block.get(params.id)
        if (!blockInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(action: "list")
            return
        }

        [blockInstance: blockInstance]
    }

    def edit() {
        def blockInstance = Block.get(params.id)
        if (!blockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(action: "list")
            return
        }
		if (debug) {
			println "Loading block::$blockInstance"
		}
		render(template: "form", model: [blockInstance: blockInstance])
		
        //[blockInstance: blockInstance]
    }

    def update() {
        def blockInstance = Block.get(params.id)
        if (!blockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(action: "list")
            return
        }

		if (debug) {
			println "Updating block with params::${params}"
		}
        blockInstance.properties = params
		if (debug) {
			println "Saving block:${blockInstance.properties}"
		}
        if (!blockInstance.save(flush: true)) {
			render(template: "blockDetails", model: [ block: blockInstance ] )
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'block.label', default: 'Block'), blockInstance.id])
		render(template: "blockDetails", model: [ block: blockInstance ] )
		// redirect(action: "show", id: blockInstance.id)
    }

    def delete() {
        def blockInstance = Block.get(params.id)
        if (!blockInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(action: "list")
            return
        }

        try {
            blockInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
