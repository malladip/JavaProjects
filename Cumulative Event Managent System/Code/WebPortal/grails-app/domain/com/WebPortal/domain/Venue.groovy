package com.WebPortal.domain

class Venue {

	String name
	String website
	Integer cost
	Integer maxCapacity
	boolean ac
	String description
	Provider provider
	Address address
	
	
/*	
	static mapping = {
		version false
	}*/
	/*
	static hasMany=[subServiceTypeVenue:SubServiceTypeVenue]*/
	

    static constraints = {
		name(nullable:false)
		website(url:true,nullable:true)
		cost(nullable:true)
		maxCapacity(nullable:true)
		ac(nullable:true)
		description(nullable:true)
		provider(nullable:false)
		address(nullable:false)
    }	
	
}
