package com.WebPortal.controller
import com.WebPortal.domain.User
import com.WebPortal.domain.Provider

class LoginController {
	
	
	def index ={
		if (isLoggedIn()) {
			redirect(uri:'/')
		}
		else {
			
			render(view:"/index",model:[details1:params.details])
		}

	}

	def checkLogin = {

		def userName=params.userName.trim()
		def password=params.password

		if(params.loginType=="0")//provider
		{

			def provider=Provider.findByUserName(userName)
			if(provider)
			{
				if(provider.password.equals(password))
				{

				session["userId"] = provider.id
				render(view:"providerHome",model:[providerId:provider.id])
				/*redirect(controller: 'Venue',action:'index',id:provider.id)
				 redirect(controller: 'OtherServices',action:'index',id:provider.id)
				 */
				}
				else
				{
					redirect(controller:"Login",action:'index',params:[details:"x"])

				}

			}
			else
			{
				
				redirect(controller:"Login",action:'index',params:[details:"x"])
			}

		}
		else if(params.loginType=="1")//user
		{

			def user=User.findByUserName(userName)
			if(user)
			{
				if(user.password.equals(password))
				{
					session["user"] = user.id
					render(view:"userHome")
				}
				else
				{
						
					redirect(controller:"Login",action:'index',params:[details:"x"])


				}

			}
			else
			{
					
				redirect(controller:"Login",action:'index',params:[details:"x"])
			}

		}
		else
		{
		
			redirect(controller:"Login",action:'index',params:[details:"x"])
		}
	}//check login
	
	private boolean isLoggedIn(){
		return ((session.getAttribute("userId") != null)||(session.getAttribute("user") != null))
	}
	
	def providerHome={
		render(view:"providerHome",model:[providerId:session.getAttribute("userId")])
		}
	
	def userHome={
	render(view:"userHome")
		}
	
	def logoutProvider(){
		session.removeAttribute("userId")
		redirect(uri : '/')
	}
	
	def logoutUser(){
		session.removeAttribute("user")
		redirect(uri : '/')
	}
	
}//class
