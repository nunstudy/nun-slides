package org.nunstudy.pathology

class Block {

	String code
	Nun nun
	BlockArea blockArea
	SubArea subArea
	String areaOtherText
	Boolean lesion
	Boolean infarction
	Boolean missing
	Boolean demented
	String slideSourceId
	Hemisphere hemisphere
	String label

	Date deleted
	Date dateCreated = new Date()
	String userCreated
	String appCreated = 'nun-slides'
	Date lastUpdated
	String userUpdated
	String appUpdated


    static constraints = {
		code(nullable:true)
		nun()
		blockArea()
		subArea(nullable: true)
		areaOtherText(nullable: true)
		lesion()
		infarction()
		missing()
		demented()
		slideSourceId()
		hemisphere(nullable: true)
		label()

		deleted(nullable: true)
		dateCreated()
		userCreated(maxSize: 16)
		appCreated(maxSize: 50)
		lastUpdated(nullable: true)
		userUpdated(nullable: true, maxSize: 16)
		appUpdated(nullable: true, maxSize: 50)
    }
	static mapping = {
		version false
		id column:'BlockID'

		code column:'BlockCode'
		nun column:'NunID'
		blockArea column:'BlockAreaID'
		subArea column:'SubAreaID'
		areaOtherText column:'AreaOtherText'
		lesion column:'Lesion'
		infarction column:'Infarction'
		missing column:'Missing'
		demented column:'Demented'
		slideSourceId column:'SlideSourceID'
		hemisphere column:'Hemisphere'
		label column:'BlockLabel'
		deleted column:'DeleteDate'
		dateCreated column:'CreateDate'
		userCreated column:'CreateUser'
		appCreated column:'CreateApp'
		lastUpdated column:'UpdateDate'
		userUpdated column:'UpdateUser'
		appUpdated column:'UpdateApp'
	}
}
