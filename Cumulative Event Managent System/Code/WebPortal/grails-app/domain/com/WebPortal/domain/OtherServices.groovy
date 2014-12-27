package com.WebPortal.domain

class OtherServices {

	String name
	String website
	String description
	ServiceType serviceType
	Provider provider
	Address address
	
	
    static constraints = {
		name(nullable:false)
		website(url:true,nullable:true)
		description(nullable:true)
    	serviceType(nullable:false)
		provider(nullable:false)
		address(nullable:false)
		}
}
