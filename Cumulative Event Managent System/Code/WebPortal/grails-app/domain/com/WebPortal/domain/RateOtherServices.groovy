package com.WebPortal.domain

class RateOtherServices {

	int rating
	User user
	OtherServices otherServices
	ServiceType serviceType
	
	
    static constraints = {
		rating(nullable:false,max:5)
		user(nullable:false)
		otherServices(nullable:false)
		serviceType(nullable:false)
    }
}
