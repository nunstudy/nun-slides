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
		def nunInstance = Nun.read(params.id)
		def blockInstance = new Block()
		blockInstance.nun = nunInstance
		blockInstance.code = "To be determined..."
		if (debug) {
			println "Creating new block::$blockInstance"
		}
 		render(template: "form", model: [blockInstance: blockInstance, editing: false])
       // [blockInstance: blockInstance]
    }

    def save() {
		def nunInstance = Nun.get(params.nun.toLong())
		// TODO: Update userCreated, slideSourceId and get nun instance
		params.nun = nunInstance
		params.userCreated = 'ast'
		params.slideSourceId = 999999
		if (debug) {
			println "Attempting to create new block with params::$params"
		}

        def blockInstance = new Block(params)
		
        if (!blockInstance.save(flush: true)) {
			flash.message = message(code: 'default.created.message', args: [message(code: 'block.label', default: 'Block'), blockInstance.id.toString()])
			redirect(controller: "nunId", action: "find", id: nunInstance?.id)
            //render(view: "create", model: [blockInstance: blockInstance])
            return
        }
		if (nunInstance) {
			nunInstance.addToBlocks(blockInstance)
		}
		
		flash.message = message(code: 'default.created.message', args: [message(code: 'block.label', default: 'Block'), blockInstance.id.toString()])
        //redirect(action: "show", id: blockInstance.id)
        redirect(controller: "nunId", action: "find", id: blockInstance.nun.id)
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
		if (debug) {
			println "Editing block::$blockInstance"
		}
        if (!blockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(action: "list")
            return
        }
		if (debug) {
			println "Loading block::$blockInstance"
		}
		render(template: "form", model: [blockInstance: blockInstance, editing: true])
		
        //[blockInstance: blockInstance]
    }

    def update() {
        def blockInstance = Block.get(params.id)
		def infoMessage = null
        if (!blockInstance) {
            //flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id.toString()])
            infoMessage = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id.toString()])
            redirect(controller:"aperioNun", action: "list")
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
			render(template: "blockInfo", model: [ block: blockInstance ] )
            return
        }

		//flash.message = message(code: 'default.updated.message', args: [message(code: 'block.label', default: 'Block'), blockInstance.id.toString()])
		infoMessage = message(code: 'default.updated.message', args: [message(code: 'block.label', default: 'Block'), blockInstance.id.toString()])
		render(template: "blockInfo", model: [ block: blockInstance, infoMessage: infoMessage  ] )
		// redirect(action: "show", id: blockInstance.id)
    }

    def delete() {
        def blockInstance = Block.get(params.id)
		if (debug) {
			println "Attempting to delete block::$blockInstance"
		}
        if (!blockInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(controller: "aperioNun", action: "list")
            return
        }

        try {
            blockInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(controller: "nunId", action: "find", id: blockInstance.nun.id)
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(controller: "nunId", action: "find", id: blockInstance.nun.id)
        }
    }
}
