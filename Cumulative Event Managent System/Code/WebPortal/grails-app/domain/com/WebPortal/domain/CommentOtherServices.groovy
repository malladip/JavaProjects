package com.WebPortal.domain

class CommentOtherServices {

	String review
	User user
	OtherServices otherServices
	ServiceType serviceType
    
	static constraints = {
		review(nullable:false,maxsize:500)
		user(nullable:false)
		otherServices(nullable:false)
    }
}
