<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paytm</title>
<script type="javascript">
	function response(){
	return document.getElementById('response').value;
}
</script>
</head>
<body>
Redirecting back to the app<br>
<form name="frm" method="post">
	<input type="hidden" id="response" name="responseField" value="${response}">
</form>
</body>
</html>