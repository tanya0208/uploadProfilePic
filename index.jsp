<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index page</title>
</head>
<body>
	<center>
		<div class="boxCss">
			<s:if test="#session.userProfile!=''">
				<a href="javascript:void(0)" onclick="upload()" class="imgCss"> <img src=<s:property value="#session.userProfile"/> width="120" height="120"></a>
			</s:if>
			<s:else>
				<a href="javascript:void(0)" onclick="upload()" class="imgCss"> <img src="images/admin.jpg" alt="user-img" width="120" height="120"></a>
			</s:else>
			<br>
			<br>
		 	<form action="uploadImg" method="post" enctype="multipart/form-data">
		     	<div class="divCss">
			     	<input type="file" id="image_src" name="userImage" label="Image" class="fileCss" />
			    	<input type="submit" value="Upload" align="center" class="submitCss btn btn-primary" />
		     	</div>  
		 	</form>
		</div>
	</center>
</body>
</html>