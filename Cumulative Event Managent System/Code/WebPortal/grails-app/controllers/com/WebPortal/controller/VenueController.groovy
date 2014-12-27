package com.WebPortal.controller

import org.apache.tools.ant.types.resources.Intersect;

import com.WebPortal.domain.Address


import com.WebPortal.domain.CommentVenue
import com.WebPortal.domain.Provider;
import com.WebPortal.domain.RateVenue
import com.WebPortal.domain.SubServiceTypeVenue;
import com.WebPortal.domain.Venue
import com.sun.org.apache.xpath.internal.operations.String;

class VenueController {

	def index ={

		render(view:"create",model:[providerId:params.id,inValid:params.inValid])

	}

	def save = {
		try{
			Venue venue = new Venue()
			Address address= new Address()
			SubServiceTypeVenue subServiceTypeVenue1 = new SubServiceTypeVenue();
			SubServiceTypeVenue subServiceTypeVenue2 = new SubServiceTypeVenue();
			SubServiceTypeVenue subServiceTypeVenue3 = new SubServiceTypeVenue();
			SubServiceTypeVenue subServiceTypeVenue4 = new SubServiceTypeVenue();
			/*
			 List<Venue> venueInstanceList = new ArrayList<Venue>();
			 List<Address> addressInstanceList = new ArrayList<Address>();
			 */
			venue.name =params.name.trim()

			address.line=params.line.trim()
			address.place=params.place.trim()
			address.city=params.city.trim()

			address.pincode=params.pincode?.toLong()

			address.phoneNumber=params.phoneNumber?.toLong()
			def address1 = address.save()

			venue.address=address1
			if(params.cost!="")
				venue.cost =params.cost?.toInteger()
			//per hour or per day
			if(params.maxCapacity!="")
				venue.maxCapacity =params.maxCapacity?.toInteger()
			if(params.ac=="1"||params.ac=="0")
				venue.ac =params.ac?.toBoolean()
			venue.website =params.website.trim()
			venue.description =params.description.trim()
			//bind(Provider, params)

			Provider provider = Provider.findById(params.providerId?.toInteger())
			venue.provider= provider

			def v=venue.save()


			subServiceTypeVenue1.subType=params.subType1
			subServiceTypeVenue1.venue= v
			subServiceTypeVenue1.save();

			subServiceTypeVenue2.subType=params.subType2
			subServiceTypeVenue2.venue= v
			subServiceTypeVenue2.save();

			subServiceTypeVenue3.subType=params.subType3
			subServiceTypeVenue3.venue= v
			subServiceTypeVenue3.save();

			subServiceTypeVenue4.subType=params.subType4
			subServiceTypeVenue4.venue= v
			subServiceTypeVenue4.save();

			/*provider=v.provider
			 List<Venue> venueInstanceList = new ArrayList<Venue>();
			 venueInstanceList.addAll(Venue.findAllByProvider(provider))*/

			redirect(controller:"Venue", action:'myList',params:[created:"y"])

		}
		catch(Exception e){
			redirect(action:"index",params:[inValid:"y"])
		}

		/*venueInstanceList.addAll(Venue.findAllBy())
		 render(view:"list", model:[venueInstanceList:venueInstanceList,venueInstanceTotal:venueInstanceList?.size(),proVar:"0"])
		 */
		//venue.provider.id=Provider.findIndexOf(userName)

		//def savedVenu = venue.save()
		//addressVenue.save()
		/*
		 Venu venu  = new Venu();
		 AddrssVenu addVenu=	new AddressVenu(name:params.place).save()
		 venu.addressVenu(addVenu)
		 venueInstanceList.addAll(Venue.findAll())
		 //	addressVenueInstanceList.addAll(AddressVenue.findAll())
		 render(view:"list", model:[venueInstanceList:venueInstanceList,venueInstanceTotal:venueInstanceList?.size()])
		 redirect(controller:'somex' ,action:'save',model:[var:var])
		 */

	}

	def fullDetails={
		def average="Not Rated"
		Venue venue=Venue.findById(params.venueId.toInteger())
		List<CommentVenue> commentVenueList=new ArrayList<CommentVenue>()
		List<SubServiceTypeVenue> subServiceTypeList=new ArrayList<SubServiceTypeVenue>()
		subServiceTypeList?.addAll(SubServiceTypeVenue.findAllByVenue(venue))
		commentVenueList.addAll(CommentVenue.findAllByVenue(venue))

		List<RateVenue> rateVenueList=new ArrayList<RateVenue>()
		rateVenueList.addAll(RateVenue.findAllByVenue(venue))

		def sum=0

		def numberOfRates=rateVenueList.size()
		for (int i=0; i<numberOfRates;i++)
		{
			sum=sum+rateVenueList[i]?.rating

		}
		if (numberOfRates!=0)
		{
			average=sum/numberOfRates
		}

		render(view:"fullDetails",model:[venue:venue,subServiceTypeList:subServiceTypeList,subServiceTypeListTotal:subServiceTypeList?.size(),proVar:params.proVar,commentVenueList:commentVenueList,rate:average
				])
	}


	def myList={
		def providerId=session.getAttribute("userId")
		Provider provider=Provider.findById(providerId)
		//params.providerId.toInteger()
		List<Venue> venueInstanceList = new ArrayList<Venue>();
		venueInstanceList.addAll(Venue.findAllByProvider(provider))
		render(view:"list",model:[venueInstanceList:venueInstanceList,venueInstanceTotal:venueInstanceList?.size(),name:"0",created:params.created,updated:params.updated,deleted:params.deleted,inValid:params.inValid])
	}


	def list = {
		List<Venue> venueInstanceList = new ArrayList<Venue>();
		venueInstanceList.addAll(Venue.findAll())
		model:[venueInstanceList:venueInstanceList,venueInstanceTotal:venueInstanceList?.size()]
	}


	def updateVenue={
		Venue venue=Venue.findById(params.venueId.toInteger())
		List<SubServiceTypeVenue> subServiceTypeList=new ArrayList<SubServiceTypeVenue>()
		subServiceTypeList.clear()
		subServiceTypeList?.addAll(SubServiceTypeVenue.findAllByVenue(venue))
		List<String> list1=new ArrayList<String>()

		for(int i=0;i<subServiceTypeList.size;i++)
			list1.add(subServiceTypeList[i].subType)


		render(view:"edit", model:[venue:venue,list1:list1])
		/*		subServiceTypeList:subServiceTypeList,subServiceTypeListTotal:subServiceTypeList?.size()*/
	}


	def update={
		try
		{

			Venue venue=Venue.findById(params.venueId.toInteger())


			Address address=venue.address

			//List<SubServiceTypeVenue> subServiceTypeList=new ArrayList<SubServiceTypeVenue>()
			//subServiceTypeList.addAll(SubServiceTypeVenue.findAllByVenue(venue))
			/*
			 SubServiceTypeVenue subServiceTypeVenue1 = (subServiceTypeList[0]==null)?new SubServiceTypeVenue():subServiceTypeList[0]
			 SubServiceTypeVenue subServiceTypeVenue2 = (subServiceTypeList[1]==null)?new SubServiceTypeVenue():subServiceTypeList[1]
			 SubServiceTypeVenue subServiceTypeVenue3 = (subServiceTypeList[2]==null)?new SubServiceTypeVenue():subServiceTypeList[2]
			 SubServiceTypeVenue subServiceTypeVenue4 = (subServiceTypeList[3]==null)?new SubServiceTypeVenue():subServiceTypeList[3]
			 */


			SubServiceTypeVenue subServiceTypeVenue1 = new SubServiceTypeVenue()
			SubServiceTypeVenue subServiceTypeVenue2 = new SubServiceTypeVenue()
			SubServiceTypeVenue subServiceTypeVenue3 = new SubServiceTypeVenue()
			SubServiceTypeVenue subServiceTypeVenue4 = new SubServiceTypeVenue()


			venue.name =params.name.trim()

			address.line=params.line.trim()
			address.place=params.place.trim()
			address.city=params.city.trim()
			address.pincode=params.pincode?.toLong()
			address.phoneNumber=params.phoneNumber?.toLong()

			def address1 = address.save(flush:true)

			venue.address=address1
			if(params.cost!="")
				venue.cost =params.cost?.toInteger()
			else
				venue.cost=null
			//per hour or per day
			if(params.maxCapacity!="")
				venue.maxCapacity =params.maxCapacity?.toInteger()
			else
				venue.maxCapacity=null
			if(params.ac=="1"||params.ac=="0")
				venue.ac =params.ac?.toBoolean()
			else
				venue.ac=null

			venue.website =params.website.trim()
			venue.description =params.description.trim()
			//bind(Provider, params)

			//Provider provider = Venue.provider
			//venue.provider= provider

			/*	
			 venue.subServiceTypeVenue.clear()
			 if(params.subType1!=null)
			 venue.addToSubServiceTypeVenue(params.subType1)
			 if(params.subType2!=null)
			 venue.addToSubServiceTypeVenue(params.subType2)
			 if(params.subType3!=null)
			 venue.addToSubServiceTypeVenue(params.subType3)
			 if(params.subType4!=null)
			 venue.addToSubServiceTypeVenue(params.subType4)
			 */


			def v=venue.save(flush:true)


			SubServiceTypeVenue.findAllByVenue(v)*.delete()


			//	venueInstanceList.addAll(Venue.findAll())
			//render(view:"list", model:[venueInstanceList:venueInstanceList,venueInstanceTotal:venueInstanceList?.size()])

			subServiceTypeVenue1.subType=params.subType1
			subServiceTypeVenue1.venue= v
			subServiceTypeVenue1?.save(flush:true)

			subServiceTypeVenue2.subType=params.subType2
			subServiceTypeVenue2.venue= v
			subServiceTypeVenue2?.save(flush:true)

			subServiceTypeVenue3.subType=params.subType3
			subServiceTypeVenue3.venue= v
			subServiceTypeVenue3?.save(flush:true)

			subServiceTypeVenue4.subType=params.subType4
			subServiceTypeVenue4.venue= v
			subServiceTypeVenue4?.save(flush:true)

			redirect(controller:"Venue", action:'myList',params:[updated:"y"])
			//redirect(uri:'/venue/myList')
			/*List<SubServiceTypeVenue> updatedSubServiceTypeList=new ArrayList<SubServiceTypeVenue>()
			 updatedSubServiceTypeList?.addAll(SubServiceTypeVenue.findAllByVenue(v))
			 render(view:"fullDetails",model:[venue:v,subServiceTypeList:updatedSubServiceTypeList,subServiceTypeListTotal:SubServiceTypeList?.size(),proVar:"0"])
			 */
			//	redirect(controller:"Venue",action:"myList",model:[provider:v.provider])
		}
		catch(Exception e){
			redirect(controller:"Venue", action:'myList',params:[inValid:"y"])
		}
	}
	def delete={
		Venue venue=Venue.findById(params.venueId.toInteger())
		//delete address
		def addr = venue.address
		SubServiceTypeVenue.findAllByVenue(venue)*.delete()
		venue.delete()
		Address.find(addr).delete()
		redirect(controller:"Venue", action:'myList',params:[deleted:"y"])
	}

	def searchResults={

		def c = Venue.createCriteria()

		def searchList = c.list {
			and {
				ilike("name",(params.searchName.trim()).concat("%"))
				//ilike("cost",params.searchCost.concat("%"))
				if(params.searchCost!="")
					le("cost",params.searchCost?.toInteger())
				if(params.searchMaxCapacity!="")
					ge("maxCapacity",params.searchMaxCapacity?.toInteger())
				if(params.searchAc=="1")
					eq("ac",true)
				//	between("cost", 100, 1000)
				//eq("branch", "London")
			}//close and
			maxResults(50)
			order("name", "asc")
		}

		def flag1,flag2
		List<Venue> venueList=new ArrayList<Venue>()
		for(int i=0;i<searchList.size();i++)
		{
			def address=Address.find(searchList[i].address)

			if((address.place==params.searchPlace.trim()))
			{
				venueList.add(searchList[i])
				flag1=1
			}
		}
		if(flag1!=1&&params.searchPlace.trim()=="")
		{
			venueList.addAll(searchList)
		}


		List<Venue> venueList2=new ArrayList<Venue>()
		for(int i=0;i<venueList.size();i++)
		{
			def address=Address.find(venueList[i].address)

			if(((address.city==params.searchCity.trim())))
			{
				venueList2.add(venueList[i])
				flag2=1
			}
		}
		if(flag2!=1&&params.searchCity.trim()=="")
		{
			venueList2.addAll(venueList)

		}


		def flag3
		List<SubServiceTypeVenue> subServiceTypeVenueList=new ArrayList<SubServiceTypeVenue>()
		List<Venue> venueList3=new ArrayList<Venue>()
		for(int i=0;i<venueList2.size();i++)
		{
			subServiceTypeVenueList.clear()
			subServiceTypeVenueList.addAll(SubServiceTypeVenue.findAllByVenue(venueList2[i]))

			for(int j=0;j<subServiceTypeVenueList.size();j++)
			{

				//flag3=1
				if(subServiceTypeVenueList[j].subType==params.searchSubType)
				{
					venueList3.add(venueList2[i])
					flag3=1
				}


			}

		}
		if((flag3!=1)&&(!params.searchSubType))
		{
			venueList3.addAll(venueList2)
		}



		/*ilike("address",address)
		 ilike("city",params.searchCity.concat("%"))
		 */
		render(view:"list",model:[venueInstanceList:venueList3,venueInstanceTotal:venueList3?.size()])
	}//search result

}//close controller
