<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="metro-bootstrap.css" rel="stylesheet">
    <link href="css/iconFont.css" rel="stylesheet">

    <!-- Load JavaScript Libraries -->
    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/jquery/jquery.widget.min.js"></script>

    <!-- Metro UI CSS JavaScript plugins -->
    <script src="js/load-metro.js"></script>

    <!-- Local JavaScript -->
    <script src="js/github.info.js"></script>
	<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

     <!-- Optional theme -->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

     <!-- Latest compiled and minified JavaScript -->
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</head>

<body class = "metro" >
<center>
        <div class="page-header" >
           <h1>PUBLIC TRANSPORT SYSTEM<br/> <small style="color:black; border-bottom:1px solid gray;">By |Prashant |Nephi Calvin|Sandeep Lagisetty|Nikhil Reddy</small></h1>
        </div>
        <div class="main-content clearfix">
            <div class="tile-area no-padding clearfix">
                <div class="tile-group no-margin no-padding clearfix" style="width: 100%">
                    <div class="tile quadro double-vertical ol-transparent">
                        <div class="tile-content">
                            <div class="carousel" data-role="carousel" data-height="100%" data-width="100%" data-controls="false">
                                <div class="slide">
                                    <img src="train.jpg"  />
										<div class="brand bg-dark opacity">
										</div>
                                </div>
                                <div class="slide">
                                    <img src="Map.jpg" />
									<div class="brand bg-dark opacity">
										</div>
								</div>
                                <div class="slide">
                                    <img src="Bus.jpg" />
									<div class="brand bg-dark opacity">
										 </div>

                                </div>
								 
                                
                            </div>
                        </div>
                    </div>
                     </div>
                        </div>
                    </div>

<form action ="userhome" target="iframe" method = "post">					
<div class="btn-group btn-group-justified" role="group" aria-label="...">
   <div class="btn-group" role="group">
     <button type="submit" class="btn btn-info" name = "edit">Edit Profile</button>
  </div>
  <div class="btn-group" role="group">
    <button type = "submit" name = "bookmark" class="btn btn-info">Bookmarks</button>
  </div>
  </div>
		</form>
<form action ="userhome"  method = "post">					
<div class="btn-group btn-group-justified" role="group" aria-label="...">
  
    
  <div class="btn-group" role="group">
    <a href="userSearch.jsp" target="iframe" style="text-decoration: none; color:white;"><button type = "button" name="search" class="btn btn-info">Search</button></a>
   
  </div>
  <div class="btn-group" role="group">
    <a href="contact.jsp" target="iframe" style="text-decoration: none; color:white;"><button type = "button" name="contact" class="btn btn-info">Contact</button></a>
  </div>
  <div class="btn-group"  role="group">
    <button type = "submit" name="logout" class="btn btn-info">Log Out</button>
  </div>
  </div>    
   
   <iframe name="iframe"  src="" style="width:1048px; height:400px; border: 2px solid black;" ></iframe>
	   
</form>
</center>
</body>
</html>
