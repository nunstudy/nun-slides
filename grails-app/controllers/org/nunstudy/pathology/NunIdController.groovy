package org.nunstudy.pathology

import org.springframework.dao.DataIntegrityViolationException
import groovy.sql.Sql
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_NUNSTUDY_ADMINISTRATIVE', 'ROLE_NUNSTUDY'])
class NunIdController {
	def springSecurityService
	def nunIdService
	def dataSource
	
	def debug = false
	
	def find() {
		/**
		 * Find Nun ID object by Aperio ID or
		 * Autopsy ID.
		 */
		def nunIdInstance = nunIdService.findNunId(params.id)
		if (!nunIdInstance) {
			flash.message = "Oops, sorry. A subject could not be found with id $params.id"
			redirect(controller:"mainMenu")			
		} else {
			if (params.openDiv) {
				if (debug) {
					println "Setting block id to::$params.blockId"
				}
				render(view: "edit", model: [nunIdInstance: nunIdInstance, blockId: params.blockId])
				return				
			}
            render(view: "edit", model: [nunIdInstance: nunIdInstance])
			//redirect(action: "show", id: nunIdInstance.id)
		}
	}	
	
	def edit() {
		def nunIdInstance = NunId.get(params.id)
		if (!nunIdInstance) {
			flash.message = "Oops, sorry. A subject could not be found with id $params.id"
			redirect(controller:"mainMenu")
		} else {
			if (params.openDiv) {
				if (debug) {
					println "Setting block id to::$params.blockId"
				}
				render(view: "edit", model: [nunIdInstance: nunIdInstance, blockId: params.blockId])
				return				
			}
			render(view: "edit", model: [nunIdInstance: nunIdInstance])
		}
	}
	
	def createTemplate() {
		def username = springSecurityService.principal.getUsername()
		def nunIdInstance = NunId.read(params.id)
		if (!nunIdInstance) {
			flash.message = "Oops, sorry. A subject could not be found with id $params.id"
			redirect(controller:"mainMenu")			
			return
		}
		if (debug) {
			println "Executing stored procedure"
		}
		Sql sql = new groovy.sql.Sql(dataSource)
		sql.execute("EXEC dbo.mr_block_from_template @NunID = ${nunIdInstance.id}, @username = ${username}") 
		if (debug) {
			println "Done executing stored procedure"
		}
		flash.message = "New block template created successfully!"
		redirect(controller: "nunId", action: "find", id: nunIdInstance?.id)
	}

}
