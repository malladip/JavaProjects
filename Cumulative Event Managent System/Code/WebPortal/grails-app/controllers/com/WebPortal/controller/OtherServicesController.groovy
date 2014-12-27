package com.WebPortal.controller
import com.WebPortal.domain.Address


import com.WebPortal.domain.CommentOtherServices

import com.WebPortal.domain.RateOtherServices
import com.WebPortal.domain.ServiceType;
import com.WebPortal.domain.Provider;
import com.WebPortal.domain.OtherServices
import com.WebPortal.domain.SubServiceTypeOtherServices
import com.sun.org.apache.xpath.internal.operations.String;

class OtherServicesController {

	/*	def index ={
	 render(view:"create",model:[providerId:params.id])
	 }
	 */
	def index={
		def serviceTypeId=params.serviceTypeId
		if(serviceTypeId.equals("2")){
			render(view:"createEventOrganizer",model:[pId:params.providerId,sType:serviceTypeId,inValid:params.inValid])

		}
		else if(serviceTypeId.equals("3")){
			//food supplier
			render(view:"createFoodSupplier",model:[pId:params.providerId,sType:serviceTypeId,inValid:params.inValid])
		}
		else{
			//music provider
			render(view:"createMusicProvider",model:[pId:params.providerId,sType:serviceTypeId,inValid:params.inValid])
		}
	}

	def save = {
		try{

			OtherServices otherServices = new OtherServices()
			Address address= new Address()
			SubServiceTypeOtherServices subServiceTypeOtherServices1 = new SubServiceTypeOtherServices();
			SubServiceTypeOtherServices subServiceTypeOtherServices2 = new SubServiceTypeOtherServices();
			SubServiceTypeOtherServices subServiceTypeOtherServices3 = new SubServiceTypeOtherServices();
			SubServiceTypeOtherServices subServiceTypeOtherServices4 = new SubServiceTypeOtherServices();

			/*List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
			 List<Address> addressInstanceList = new ArrayList<Address>();*/

			otherServices.name =params.name.trim()

			address.line=params.line.trim()
			address.place=params.place.trim()
			address.city=params.city.trim()
			address.pincode=params.pincode?.toLong()
			address.phoneNumber=params.phoneNumber?.toLong()
			def address1 = address.save()
			otherServices.address=address1
			otherServices.website =params.website.trim()
			otherServices.description =params.description.trim()
			//bind(Provider, params)

			Provider provider = Provider.findById(params.providerId?.toInteger())
			otherServices.provider= provider

			ServiceType  serviceType= ServiceType.findById(params.serviceType?.toInteger())
			otherServices.serviceType= serviceType


			def os=otherServices.save()


			if(serviceType.id==2){
				subServiceTypeOtherServices1.subType=params.subType1
				subServiceTypeOtherServices1.otherServices= os
				subServiceTypeOtherServices1.serviceType=serviceType
				subServiceTypeOtherServices1.save();

				subServiceTypeOtherServices2.subType=params.subType2
				subServiceTypeOtherServices2.otherServices= os
				subServiceTypeOtherServices2.serviceType=serviceType
				subServiceTypeOtherServices2.save();

				subServiceTypeOtherServices3.subType=params.subType3
				subServiceTypeOtherServices3.otherServices= os
				subServiceTypeOtherServices3.serviceType=serviceType
				subServiceTypeOtherServices3.save();

				subServiceTypeOtherServices4.subType=params.subType4
				subServiceTypeOtherServices4.otherServices= os
				subServiceTypeOtherServices4.serviceType=serviceType
				subServiceTypeOtherServices4.save();
			}

			else if(serviceType.id==3){
				//food supplier
				subServiceTypeOtherServices1.subType=params.subType1
				subServiceTypeOtherServices1.otherServices= os
				subServiceTypeOtherServices1.serviceType=serviceType
				subServiceTypeOtherServices1.save();

				subServiceTypeOtherServices2.subType=params.subType2
				subServiceTypeOtherServices2.otherServices= os
				subServiceTypeOtherServices2.serviceType=serviceType
				subServiceTypeOtherServices2.save();
			}
			else{
				//music provider
				subServiceTypeOtherServices1.subType=params.subType1
				subServiceTypeOtherServices1.otherServices= os
				subServiceTypeOtherServices1.serviceType=serviceType
				subServiceTypeOtherServices1.save();

				subServiceTypeOtherServices2.subType=params.subType2
				subServiceTypeOtherServices2.otherServices= os
				subServiceTypeOtherServices2.serviceType=serviceType
				subServiceTypeOtherServices2.save();
			}

			provider=otherServices.provider
			serviceType=otherServices.serviceType
			List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
			otherServicesInstanceList.addAll(OtherServices.findAllByProviderAndServiceType(provider,serviceType))
			render(view:"list",model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size(),name:"0",created:"y"])

			/*otherServicesInstanceList.addAll(OtherServices.findAll())
			 render(view:"list", model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size()])
			 */
		}//try
		catch(Exception e)
		{
			redirect(action:"index",params:[inValid:"y"])
		}//catch
	}//function

	/*def list = {
	 List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
	 otherServicesInstanceList.addAll(OtherServices.findAll())
	 model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size()]
	 }*/

	def fullDetails={
		def average="Not Rated"
		OtherServices otherServices=OtherServices.findById(params.otherServicesId.toInteger())
		List<CommentOtherServices> commentOtherServicesList=new ArrayList<CommentOtherServices>()
		List<SubServiceTypeOtherServices> subServiceTypeList=new ArrayList<SubServiceTypeOtherServices>()
		subServiceTypeList?.addAll(SubServiceTypeOtherServices.findAllByOtherServices(otherServices))
		commentOtherServicesList.addAll(CommentOtherServices.findAllByOtherServices(otherServices))
		List<RateOtherServices> rateOtherServicesList=new ArrayList<RateOtherServices>()
		rateOtherServicesList.addAll(RateOtherServices.findAllByOtherServices(otherServices))

		def sum=0
		def numberOfRates=rateOtherServicesList.size()
		for (int i=0; i<numberOfRates;i++)
		{
			sum=sum+rateOtherServicesList[i]?.rating

		}
		if (numberOfRates!=0)
		{
			average=sum/numberOfRates
		}
		render(view:"fullDetails",model:[otherServicesInstance:otherServices,subServiceTypeList:subServiceTypeList,subServiceTypeListTotal:subServiceTypeList?.size(),proVar:params.proVar,commentOtherServicesList:commentOtherServicesList,rate:average
				])
	}

	def myEventOrganizersList={
		def providerId=session.getAttribute("userId")
		Provider provider=Provider.findById(providerId)
		//params.providerId.toInteger()
		ServiceType serviceType=ServiceType.findById(2)
		List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
		otherServicesInstanceList.addAll(OtherServices.findAllByProviderAndServiceType(provider,serviceType))
		render(view:"list",model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size(),name:"0",updated:params.updated,deleted:params.deleted,inValid:params.inValid])

	}

	def myFoodSuppliersList={
		def providerId=session.getAttribute("userId")
		Provider provider=Provider.findById(providerId)
		//params.providerId.toInteger()
		ServiceType serviceType=ServiceType.findById(3)
		List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
		otherServicesInstanceList.addAll(OtherServices.findAllByProviderAndServiceType(provider,serviceType))
		render(view:"list",model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size(),name:"0",updated:params.updated,deleted:params.deleted,inValid:params.inValid])

	}
	def myMusicProvidersList={
		def providerId=session.getAttribute("userId")
		Provider provider=Provider.findById(providerId)
		//params.providerId.toInteger()
		ServiceType serviceType=ServiceType.findById(4)
		List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
		otherServicesInstanceList.addAll(OtherServices.findAllByProviderAndServiceType(provider,serviceType))
		render(view:"list",model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size(),name:"0",updated:params.updated,deleted:params.deleted,inValid:params.inValid])

	}

	def listEventOrganizers = {
		List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
		ServiceType  serviceType= ServiceType.findById(2)
		otherServicesInstanceList.addAll(OtherServices.findAllByServiceType(serviceType))
		render(view:"list",model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size(),serviceType:serviceType])

	}
	def listFoodSuppliers = {
		List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
		ServiceType  serviceType= ServiceType.findById(3)
		otherServicesInstanceList.addAll(OtherServices.findAllByServiceType(serviceType))
		render(view:"list",model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size(),serviceType:serviceType])

	}
	def listMusicProviders = {
		List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
		ServiceType  serviceType= ServiceType.findById(4)
		otherServicesInstanceList.addAll(OtherServices.findAllByServiceType(serviceType))
		render(view:"list",model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size(),serviceType:serviceType])

	}
	def updateOtherServices={
		OtherServices otherServices=OtherServices.findById(params.otherServicesId.toInteger())
		List<SubServiceTypeOtherServices> subServiceTypeList=new ArrayList<SubServiceTypeOtherServices>()
		subServiceTypeList?.addAll(SubServiceTypeOtherServices.findAllByOtherServices(otherServices))
		List<String> list1=new ArrayList<String>()
		ServiceType serviceType=otherServices.serviceType

		for(int i=0;i<subServiceTypeList.size;i++)
			list1.add(subServiceTypeList[i].subType)


		render(view:"edit", model:[otherServices:otherServices,list1:list1,serviceTypeId:serviceType.id])
	}

	def update={


		OtherServices otherServices = OtherServices.findById(params.otherServicesId.toInteger())
		Address address= otherServices.address

		SubServiceTypeOtherServices subServiceTypeOtherServices1 = new SubServiceTypeOtherServices();
		SubServiceTypeOtherServices subServiceTypeOtherServices2 = new SubServiceTypeOtherServices();
		SubServiceTypeOtherServices subServiceTypeOtherServices3 = new SubServiceTypeOtherServices();
		SubServiceTypeOtherServices subServiceTypeOtherServices4 = new SubServiceTypeOtherServices();


		/*List<OtherServices> otherServicesInstanceList = new ArrayList<OtherServices>();
		 List<Address> addressInstanceList = new ArrayList<Address>();
		 */
		try{

			otherServices.name =params.name.trim()

			address.line=params.line.trim()
			address.place=params.place.trim()
			address.city=params.city.trim()
			address.pincode=params.pincode?.toLong()
			address.phoneNumber=params.phoneNumber?.toLong()
			def address1 = address.save(flush:true)
			otherServices.address=address1
			otherServices.website =params.website.trim()
			otherServices.description =params.description.trim()
			//bind(Provider, params)

			/*Provider provider = Provider.findById(params.providerId?.toInteger())
			 otherServices.provider= provider
			 */
			//		ServiceType  serviceType= ServiceType.findById(params.serviceType?.toInteger())
			//otherServices.serviceType= serviceType



			def os=otherServices.save(flush:true)

			def serviceType=os.serviceType
			SubServiceTypeOtherServices.findAllByOtherServices(os)*.delete()

			if(serviceType.id==2){
				subServiceTypeOtherServices1.subType=params.subType1
				subServiceTypeOtherServices1.otherServices= os
				subServiceTypeOtherServices1.serviceType=serviceType
				subServiceTypeOtherServices1?.save(flush:true);

				subServiceTypeOtherServices2.subType=params.subType2
				subServiceTypeOtherServices2.otherServices= os
				subServiceTypeOtherServices2.serviceType=serviceType
				subServiceTypeOtherServices2?.save(flush:true);

				subServiceTypeOtherServices3.subType=params.subType3
				subServiceTypeOtherServices3.otherServices= os
				subServiceTypeOtherServices3.serviceType=serviceType
				subServiceTypeOtherServices3?.save(flush:true);

				subServiceTypeOtherServices4.subType=params.subType4
				subServiceTypeOtherServices4.otherServices= os
				subServiceTypeOtherServices4.serviceType=serviceType
				subServiceTypeOtherServices4?.save(flush:true);
				//redirect(uri:'/otherServices/myEventOrganizersList',params:[updated:"y"])
				redirect(action:'myEventOrganizersList',params:[updated:"y"])
			}

			else if(serviceType.id==3){
				//food supplier
				subServiceTypeOtherServices1.subType=params.subType1
				subServiceTypeOtherServices1.otherServices= os
				subServiceTypeOtherServices1.serviceType=serviceType
				subServiceTypeOtherServices1?.save(flush:true);

				subServiceTypeOtherServices2.subType=params.subType2
				subServiceTypeOtherServices2.otherServices= os
				subServiceTypeOtherServices2.serviceType=serviceType
				subServiceTypeOtherServices2?.save(flush:true);
				//redirect(uri:'/otherServices/myFoodSuppliersList',params:[updated:"y"])
				redirect(action:'myFoodSuppliersList',params:[updated:"y"])
			}
			else{
				//music provider
				subServiceTypeOtherServices1.subType=params.subType1
				subServiceTypeOtherServices1.otherServices= os
				subServiceTypeOtherServices1.serviceType=serviceType
				subServiceTypeOtherServices1?.save(flush:true);

				subServiceTypeOtherServices2.subType=params.subType2
				subServiceTypeOtherServices2.otherServices= os
				subServiceTypeOtherServices2.serviceType=serviceType
				subServiceTypeOtherServices2?.save(flush:true);
				//	redirect(uri:'/otherServices/myMusicProvidersList',params:[updated:"y"])
				redirect(action:'myMusicProvidersList',params:[updated:"y"])
			}
		}
		catch(Exception e){
			if(otherServices.serviceType.id==2)
			{
				redirect(action:'myEventOrganizersList',params:[inValid:"y"])
			}
			else if(otherServices.serviceType.id==3){
				redirect(action:'myFoodSuppliersList',params:[inValid:"y"])
			}
			else{
				redirect(action:'myMusicProvidersList',params:[inValid:"y"])
			}

		}
		/*otherServicesInstanceList.addAll(OtherServices.findAll())
		 render(view:"list", model:[otherServicesInstanceList:otherServicesInstanceList,otherServicesInstanceTotal:otherServicesInstanceList?.size()])
		 */
	}

	def delete={

		OtherServices otherServices=OtherServices.findById(params.otherServicesId.toInteger())
		def serviceType=otherServices.serviceType
		//delete address
		def addr = otherServices.address
		SubServiceTypeOtherServices.findAllByOtherServices(otherServices)*.delete()
		otherServices.delete()
		Address.find(addr).delete()
		if(serviceType.id==2)
			redirect(controller:"OtherServices", action:'myEventOrganizersList',params:[deleted:"y"])
		if(serviceType.id==3)
			redirect(controller:"OtherServices", action:'myFoodSuppliersList',params:[deleted:"y"])
		if(serviceType.id==4)
			redirect(controller:"OtherServices", action:'myMusicProvidersList',params:[deleted:"y"])

	}


	def searchResults={

		def c = OtherServices.createCriteria()
		def serviceType=ServiceType.findById(params.serviceTypeId?.toInteger())
		def searchList = c.list {
			and {
				ilike("name",(params.searchName.trim()).concat("%"))
				eq("serviceType",serviceType)
				//ilike("cost",params.searchCost.concat("%"))
			}//close and
			maxResults(50)
			order("name", "asc")
		}


		def flag1,flag2
		List<OtherServices> otherServicesList=new ArrayList<OtherServices>()
		for(int i=0;i<searchList.size();i++)
		{
			def address=Address.find(searchList[i].address)

			if((address.place==params.searchPlace.trim()))
			{
				otherServicesList.add(searchList[i])
				flag1=1
			}
		}
		if(flag1!=1&&params.searchPlace.trim()=="")
		{
			otherServicesList.addAll(searchList)
		}


		List<OtherServices> otherServicesList2=new ArrayList<OtherServices>()
		for(int i=0;i<otherServicesList.size();i++)
		{
			def address=Address.find(otherServicesList[i].address)

			if(((address.city==params.searchCity.trim())))
			{
				otherServicesList2.add(otherServicesList[i])
				flag2=1
			}
		}
		if(flag2!=1&&params.searchCity.trim()=="")
		{
			otherServicesList2.addAll(otherServicesList)

		}


		def flag3
		List<SubServiceTypeOtherServices> subServiceTypeOtherServicesList=new ArrayList<SubServiceTypeOtherServices>()
		List<OtherServices> otherServicesList3=new ArrayList<OtherServices>()
		for(int i=0;i<otherServicesList2.size();i++)
		{
			subServiceTypeOtherServicesList.clear()
			subServiceTypeOtherServicesList.addAll(SubServiceTypeOtherServices.findAllByOtherServices(otherServicesList2[i]))
			for(int j=0;j<subServiceTypeOtherServicesList.size();j++)
			{

				//flag3=1
				if(subServiceTypeOtherServicesList[j].subType==params.searchSubType)
				{
					otherServicesList3.add(otherServicesList2[i])
					flag3=1
				}


			}

		}
		if((flag3!=1)&&(!params.searchSubType))
		{
			otherServicesList3.addAll(otherServicesList2)
		}



		/*ilike("address",address)
		 ilike("city",params.searchCity.concat("%"))
		 */
		//render(view:"list",model:[venueInstanceList:venueList3,venueInstanceTotal:venueList3?.size()])
		render(view:"list",model:[otherServicesInstanceList:otherServicesList3,otherServicesInstanceTotal:otherServicesList3?.size(),serviceType:serviceType])
	}//close search result
}//close class
