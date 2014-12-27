package com.WebPortal.domain

class SubServiceTypeOtherServices {

	String subType	
	OtherServices otherServices
	ServiceType serviceType
	
    static constraints = {
		subType(nullable:false)
		otherServices(nullable:false)
		serviceType(nullable:false)
    }
	
	//static hasMany = [serivceTypes : ServiceType, otherSerives:OtherServices]
}
