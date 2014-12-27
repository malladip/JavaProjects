package com.WebPortal.domain

class User {
	
	String userName
	String firstName
	String lastName
	String gender
	String emailId
	Long mobile
	String password
	
	
    static constraints = {
		
		userName(size: 1..25, unique: true,nullable:false)
		firstName(size: 1..45,nullable:false)
		lastName(size: 1..45,nullable:false)
		gender(nullable:false)
		emailId(email: true,nullable:true)
		mobile(maxsize: 10,minsize: 10,nullable:true)
		password(nullable:false)
		
		}
	
}
