package com.WebPortal.domain

class RateVenue {

	int rating
	User user
	Venue venue
	
    static constraints = {
		rating(nullable:false,max:5)
		user(nullable:false)
		venue(nullable:false)
		
    }
}
