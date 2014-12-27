package com.WebPortal.controller

import com.WebPortal.domain.User
import com.sun.org.apache.xpath.internal.operations.String;

class UserController {

	/*def index ={
	render(view:"login")
//		render(view:"create")
	}*/

	
	def createIndex ={
		
			render(view:"create",model:[isThere:params.isThere])
		}
	
	def save = {
		User user = new User()
		List<String> userUserNameList = new ArrayList<String>();
		List<User> userList = new ArrayList<User>();
		userList.addAll(User.findAll())
		
		for(int i=0;i<userList.size;i++)
		userUserNameList.add(userList[i].userName)
		

		user.firstName =params.firstName
		user.lastName = params.lastName
		user.userName = params.userName
		
		
		if(userUserNameList.contains(user.userName))
		{
		
			redirect(controller:"User", action:"createIndex",params:[isThere:"y"])
		}
		
		else{
			user.password =params.password
			user.gender =params.gender
			user.emailId =params.emailId
			if(params.mobile!="")
			user.mobile =params.mobile.toLong()
			else
			user.mobile=null
			user.save()
				redirect(controller:"Login",action:"index",params:[details:"z"])
		}
		
		//userInstanceList.addAll(User.findAll())

			//	render(view:"list", model:[userInstanceList:userInstanceList,userInstanceTotal:userInstanceList?.size()])
	
		}
	
	/*def checkLogin = {
		if(params.loginType.equals("0"))
		{
			redirect(controller:"Provider",action:'checkLogin',model:[userName:params.userName,password:params.password])
			
		}
		def userName=params.userName
		def password=params.password
		
		
		
		def user=User.findByUserName(userName)
		if(user)
		{
			if(user.password.equals(password))
			{
			render "successfully logged in"
			}
			else
			{
				
				redirect(controller:"User",action:'index')
		
			}
			
		}
		else 
		{
			//redirect(controller:"User",action:'index')
		}
}*/
	
}
