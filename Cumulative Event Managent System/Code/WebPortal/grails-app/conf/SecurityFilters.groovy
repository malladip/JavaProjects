
class SecurityFilters {
   def filters = {
       loginCheck(uri:'/', invert:true) {
           before = {
			   // && !controllerName.equals('/search')
              /*if (!session.userId && !uri.equals('/WebPortal/')) {
                  redirect(uri:'/')
                  return false
               }*/
           }
       }
   }
}