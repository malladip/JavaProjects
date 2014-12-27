package com.WebPortal.domain

class SubServiceTypeVenue {

	String subType
	Venue venue
	
    static constraints = {
		subType(nullable:false)
		venue(nullable:false)
    }
}
