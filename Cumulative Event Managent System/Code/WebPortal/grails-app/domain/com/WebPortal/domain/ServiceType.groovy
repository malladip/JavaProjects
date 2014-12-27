package com.WebPortal.domain

class ServiceType {
	
	String type
	
    static constraints = {
		type(nullable:false,unique:true)
    }
}
