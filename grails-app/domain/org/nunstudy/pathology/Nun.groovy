package org.nunstudy.pathology

class Nun {
	String lastName
	String firstName
	Date birthDate
	Date deathDate
	Double brainMass
	Date dateSecProc
	
	static hasMany = [ blocks: Block ]

    static constraints = {
		lastName()
		firstName nullable: true
		birthDate nullable: true
		deathDate nullable: true
		brainMass nullable: true
		dateSecProc nullable: true
    }
	
	static mapping = {
		table 'nuns'
		version false
		id column:'NunID', type: 'long', sqlType: 'int'

		lastName column:'LastName'
		firstName column:'FirstName'
		birthDate column:'Birthdate'
		deathDate column:'DeathDate'
		brainMass column:'BrainMass'
		dateSecProc column:'DateSecProc'
	}

}
