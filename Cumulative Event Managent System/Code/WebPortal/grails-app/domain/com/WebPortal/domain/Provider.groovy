package com.WebPortal.domain

class Provider {

	String userName
	String organizationName
	String contactName
	Long contactNumber
	String emailId
	String password
	
    static constraints = {
		userName(size: 1..25, unique: true,nullable:false)
		organizationName(size: 1..45,nullable:false)
		contactName(size: 1..45,nullable:false)
		contactNumber(nullable:false)
		emailId(email: true,nullable:false)
		password(nullable:false)
    }
}
