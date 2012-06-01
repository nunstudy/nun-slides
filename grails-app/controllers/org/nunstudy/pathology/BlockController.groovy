package org.nunstudy.pathology

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured
import grails.plugin.cache.CacheEvict

@Secured(['ROLE_NUNSTUDY_ADMINISTRATIVE', 'ROLE_NUNSTUDY'])
class BlockController {
	def springSecurityService
	def debug = true
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

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
	
	@CacheEvict("aperioNunListCache")
    def save() {
		def username = springSecurityService.principal.getUsername()
		def nunInstance = Nun.get(params.nun.toLong())
		// TODO: Update userCreated, slideSourceId and get nun instance
		params.nun = nunInstance
		params.userCreated = username
		params.userUpdated = username
		params.slideSourceId = 0		// Default value = 0? - found this in [mr_block_from_template] stored procedure created by AJZ
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
		
		flash.message = "Block $blockInstance created successfully!"
        //redirect(action: "show", id: blockInstance.id)
        redirect(controller: "nunId", action: "find", id: blockInstance.nun.id, params: [ openDiv: true, blockId: blockInstance.id ])
    }

    def edit() {
        def blockInstance = Block.get(params.id)
		if (debug) {
			println "Editing block::$blockInstance"
		}
        if (!blockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(controller: "nunId", action: "find")
            return
        }
		if (debug) {
			println "Loading block::$blockInstance"
		}
		render(template: "form", model: [blockInstance: blockInstance, editing: true])
		
    }

	@CacheEvict("aperioNunListCache")
    def update() {
		def username = springSecurityService.principal.getUsername()
        def blockInstance = Block.get(params.id)
		def infoMessage = null
        if (!blockInstance) {
            //flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id.toString()])
            infoMessage = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id.toString()])
            redirect(controller:"aperioNun", action: "list")
            return
        }

		params.userUpdated = username
		if (debug) {
			println "Updating block with params::${params}"
		}
        blockInstance.properties = params
        if (!blockInstance.save(flush: true)) {
			render(template: "blockInfo", model: [ blockInstance: blockInstance ] )
            return
        }
		//flash.message = message(code: 'default.updated.message', args: [message(code: 'block.label', default: 'Block'), blockInstance.id.toString()])
		flash.message = "Block $blockInstance updated successfully!"
		//infoMessage = message(code: 'default.updated.message', args: [message(code: 'block.label', default: 'Block'), blockInstance.id.toString()])
		//render(template: "blockInfo", model: [ blockInstance: blockInstance, infoMessage: infoMessage  ] )
        redirect(controller: "nunId", action: "find", id: blockInstance.nun.id, params: [ openDiv: true, blockId: blockInstance.id ])
   }

	@CacheEvict("aperioNunListCache")
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
			flash.message = "Block $blockInstance deleted"
            redirect(controller: "nunId", action: "find", id: blockInstance.nun.id)
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'block.label', default: 'Block'), params.id])
            redirect(controller: "nunId", action: "find", id: blockInstance.nun.id, params: [ openDiv: true, blockId: blockInstance.id ])
        }
    }
	
	def deleteStain() {
		def stainInstance = Stain.get(params.id)
		def infoMessage = ""
		if (!stainInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'stain.label', default: 'Stain'), params.id.toString()])
			redirect(controller: "aperioNun", action: "list")
			return
		}
		// Don't delete, just mark as deleted with a date
		stainInstance.dateDeleted = new Date()
		if (debug) {
			println "Attempting to save stain::$stainInstance"
		}
		if (!stainInstance.save(flush: true)) {
			flash.message = message(code: 'default.created.message', args: [message(code: 'stain.label', default: 'Stain'), stainInstance.id.toString()])
			redirect(controller: "nunId", action: "find", id: stainInstance.block.nun.id)
			return
		}

		if (debug) {
			println "Stain saved, updating block info for block::${stainInstance.block}"
		}
		//infoMessage = "Slide $stainInstance removed"
		//redirect(controller: "nunId", action: "find", id: stainInstance.block.nun.id)
		//render(template: "blockInfo", model: [ blockInstance: stainInstance.block, infoMessage: infoMessage  ] )
		flash.message = "Slide $stainInstance removed"
		redirect(controller: "nunId", action: "find", id: stainInstance.block.nun.id, params: [ openDiv: true, blockId: stainInstance.block.id ])
		
	}
}
