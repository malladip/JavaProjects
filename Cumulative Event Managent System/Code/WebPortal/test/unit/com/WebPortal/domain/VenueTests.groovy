package com.WebPortal.domain


import com.WebPortal.domain.Address
import com.WebPortal.domain.Provider
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Venue)
@Mock([Address,Provider])
class VenueTests {

	
    void testcreateVenue() {
		//,
		when:
		Address address = new Address(line:"ert",place:"sdd",city:"city",pincode:2333, phoneNumber:(Long)2222).save()
		Provider provider= new Provider(userName:"first",organizationName:"google",contactName:"google",contactNumber:(Long)500,emailId:"prashanth@gmail.com", password:"prashanth").save()
		Venue venue = new Venue(name:"sample",ac:true,cost:100,maxCapacity:200,desc:"this is the",website:"http://www.google.com",provider:provider,address:address).save()
		
				//
		then:
		address.id != null
		venue.id !=null
    }
}
