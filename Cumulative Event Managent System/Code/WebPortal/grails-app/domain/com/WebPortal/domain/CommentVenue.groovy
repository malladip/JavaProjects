package com.WebPortal.domain

class CommentVenue {

	String review
	User user
	Venue venue
	
    static constraints = {
		review(nullable:false,maxsize:500)
		user(nullable:false)
		venue(nullable:false)
    }
}
