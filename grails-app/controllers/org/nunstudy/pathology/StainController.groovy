package org.nunstudy.pathology

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_NUNSTUDY_ADMINISTRATIVE', 'ROLE_NUNSTUDY'])
class StainController {
	def springSecurityService
	def debug = false
	
	def create() {
		def blockInstance = Block.read(params.id)
		def stainInstance = new Stain()
		stainInstance.block = blockInstance
		
		if (debug) {
			println "Creating new stain::$stainInstance"
		}
		 render(template: "form", model: [stainInstance: stainInstance, editing: false])		
	}

	def update() {
		def username = springSecurityService.principal.getUsername()
		def stainInstance = Stain.get(params.id)
		def infoMessage = null
		if (!stainInstance) {
			//flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id.toString()])
			infoMessage = message(code: 'default.not.found.message', args: [message(code: 'stain.label', default: 'Stain'), params.id.toString()])
			redirect(controller:"aperioNun", action: "list")
			return
		}

		params.userUpdated = username
		if (debug) {
			println "Updating stain with params::${params}"
		}
		stainInstance.properties = params
		if (!stainInstance.save(flush: true)) {
			infoMessage = "Oops, slide edits could not be saved."
			render(template: "/block/blockInfo", model: [ blockInstance: stainInstance.block ] )
			return
		}

		//flash.message = message(code: 'default.updated.message', args: [message(code: 'block.label', default: 'Block'), blockInstance.id.toString()])
		infoMessage = message(code: 'default.updated.message', args: [message(code: 'stain.label', default: 'Stain'), stainInstance.id.toString()])
		render(template: "/block/blockInfo", model: [ blockInstance: stainInstance.block, infoMessage: infoMessage  ] )
		// redirect(action: "show", id: blockInstance.id)
	}
	
	def save() {
		def username = springSecurityService.principal.getUsername()
		def blockInstance = Block.get(params.block.toLong())
		params.block = blockInstance
		params.userCreated = username
		params.userUpdated = username
		if (debug) {
			println "Attempting to create new stain with params::$params"
		}

		def stainInstance = new Stain(params)
		
		if (!stainInstance.save(flush: true)) {
			flash.message = message(code: 'default.created.message', args: [message(code: 'block.label', default: 'Stain'), stainInstance.id.toString()])
			redirect(controller: "nunId", action: "edit", id: blockInstance?.nun.id)
			return
		}
		if (stainInstance) {
			blockInstance.addToStains(stainInstance)
		}
		
		flash.message = "${stainInstance.toString().toUpperCase()} Stain created for Block: $blockInstance"
		redirect(controller: "nunId", action: "edit", id: blockInstance.nun.id, params: [ openDiv: true, blockId: blockInstance.id ])
	}
		
}
