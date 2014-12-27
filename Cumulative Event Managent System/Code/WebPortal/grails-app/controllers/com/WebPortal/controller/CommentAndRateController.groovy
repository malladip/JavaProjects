package com.WebPortal.controller
import com.WebPortal.domain.CommentOtherServices
import com.WebPortal.domain.CommentVenue
import com.WebPortal.domain.OtherServices
import com.WebPortal.domain.RateOtherServices
import com.WebPortal.domain.RateVenue
import com.WebPortal.domain.User
import com.WebPortal.domain.Venue

class CommentAndRateController {
	def saveVenueComment={
		CommentVenue commentVenue=new CommentVenue()
		Venue venue=Venue.findById(params.venueId.toInteger())
		User user=User.findById(session.getAttribute("user"))
		commentVenue.review=params.review
		commentVenue.venue=venue
		commentVenue.user=user
		commentVenue.save(flush:true)
		redirect(controller:"Venue", action:'list')
		
	} 

	def saveOtherServicesComment={
		CommentOtherServices commentOtherServices=new CommentOtherServices()
		OtherServices otherServices=OtherServices.findById(params.otherServicesId.toInteger())
		User user=User.findById(session.getAttribute("user"))
		commentOtherServices.serviceType=otherServices.serviceType
		commentOtherServices.review=params.review
		commentOtherServices.otherServices=otherServices
		commentOtherServices.user=user
		commentOtherServices.save(flush:true)
		if(otherServices.serviceType.id==2)
		redirect(controller:"OtherServices", action:'listEventOrganizers')
		else if(otherServices.serviceType.id==3)
		redirect(controller:"OtherServices", action:'listFoodSuppliers')
		else
		redirect(controller:"OtherServices", action:'listMusicProviders')
		}
	def saveVenueRate={
		Venue venue=Venue.findById(params.venueId.toInteger())
		RateVenue rateVenue=new RateVenue()
		User user=User.findById(session.getAttribute("user"))
		rateVenue.rating=params.rating.toInteger()
		 rateVenue.user=user
		 rateVenue.venue=venue
		if (RateVenue.findByUserAndVenue(user,venue)){
			RateVenue.findByUserAndVenue(user,venue).delete()
			rateVenue.save(flush:true)
		
		}
		else
		{
			rateVenue.save(flush:true)
		}
		redirect(controller:"Venue", action:'list')
		
	}
	
	def saveOtherServicesRate={
		OtherServices otherServices=OtherServices.findById(params.otherServicesId.toInteger())
		RateOtherServices rateOtherServices=new RateOtherServices()
		User user=User.findById(session.getAttribute("user"))
		rateOtherServices.serviceType=otherServices.serviceType
		rateOtherServices.rating=params.rating.toInteger()
		 rateOtherServices.user=user
		 rateOtherServices.otherServices=otherServices
		if (RateOtherServices.findByUserAndOtherServices(user,otherServices)){
			RateOtherServices.findByUserAndOtherServices(user,otherServices).delete()
			rateOtherServices.save(flush:true)
		}
		else
		{
			rateOtherServices.save(flush:true)
		}
		if(otherServices.serviceType.id==2)
		redirect(controller:"OtherServices", action:'listEventOrganizers')
		else if(otherServices.serviceType.id==3)
		redirect(controller:"OtherServices", action:'listFoodSuppliers')
		else
		redirect(controller:"OtherServices", action:'listMusicProviders')
	}
}
