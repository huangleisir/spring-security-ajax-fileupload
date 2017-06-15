<%@page session="false"%>
<html>
<body>
	<h1>Title : ${title}</h1>	
	<h1>Message : ${message}</h1>	
	<input style="width:300px;" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</body>
</html>