package com.WebPortal.controller

import com.WebPortal.domain.Provider
import com.sun.org.apache.xpath.internal.operations.String;

class ProviderController {
	
	/*	def index ={
		
			render(view:"login")
		}
	*/

	
	def createIndex ={
		
			render(view:"create",model:[isThere:params.isThere])
		}
		 
		def save = {//register
			Provider provider = new Provider()
			List<String> providerUserNameList = new ArrayList<String>();
			List<Provider> providerList = new ArrayList<Provider>();
			
			providerList.addAll(Provider.findAll())
			
			for(int i=0;i<providerList.size;i++)
			providerUserNameList.add(providerList[i].userName)
			
			
			provider.organizationName = params.organizationName
			provider.userName = params.userName
			
			if(providerUserNameList.contains(provider.userName))
			{
				
				redirect(controller:"Provider", action:"createIndex",params:[isThere:"y"])
			
				}
			else{
			provider.password = params.password
			provider.contactName = params.contactName
			provider.contactNumber =params.contactNumber.toLong()
			provider.emailId = params.emailId
			
			def p=provider.save()
			
			//redirect(controller: 'Venue',action:'index',id:p?.id)
			redirect(controller:"Login",action:"index",params:[details:"z"])
			//render(view:"/login/providerHome",model:[providerId:p.id])
			}
			//for listing providers:
			//providerInstanceList.addAll(Provider.findAll())
			//render(view:"list", model:[providerInstanceList:providerInstanceList,providerInstanceTotal:providerInstanceList?.size()])
		
			}
		
	/*	def checkLogin = {
			
			def userName=params.userName
			def password=params.password
			
			
			def user=Provider.findByUserName(userName)
			if(user)
			{
				if(user.password.equals(password))
				{
					
					//redirect(controller: 'Venue',action:'index',id:user.id)
					redirect(controller: 'OtherServices',action:'index',id:user.id)
				}
				else
				{
					
					redirect(controller:"User",action:'index')
			
					}
				
			}
			else
			{
				redirect(controller:"User",action:'index')
			}
	}*/
}
