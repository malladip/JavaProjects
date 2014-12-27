package com.WebPortal.domain

class Address {

	String line
	String place
	String city
	Long pincode
	Long phoneNumber
	
    static constraints = {
		line(nullable:true)
		place(nullable:false)
		city(nullable:false)
		pincode(nullable:false)
		phoneNumber(nullable:false)
    }
}
