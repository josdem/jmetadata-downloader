<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubuntu One Music Authorizer</title>
        
        <style type="text/css">
        	.fullscreenDiv {
			    width: 100%;
			    height: auto;
			    bottom: 0px;
			    top: 0px;
			    left: 0;
			    position: absolute;
			}
			.center {
			    position: absolute;
			    width: 800px;
			    height: 200px;
			    top: 50%;
			    left: 50%;
			    margin-top: -25px;
			    margin-left: -300px;
			    font-size: x-large;
			}
        </style>
    </head>
    <body>
    	<div class='fullscreenDiv'>
    		<div class="center">Oauth Verifier Code: ${it}</div>
		</div>
    </body>
</html>
