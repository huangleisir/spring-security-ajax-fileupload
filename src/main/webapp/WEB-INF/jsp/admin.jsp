<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
	   <h2>Welcome : ${pageContext.request.userPrincipal.name} </h2>
           | <c:url var="logoutUrl" value="/j_spring_security_logout"/>
		    <form class="form-inline" action="${logoutUrl}" method="post">
		      <input type="submit" value="Log out" />
		      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    </form> 
		    
		    <i>Uploading File With Ajax</i><br/>		    
			<form id="form2" method="post" action="${pageContext.request.contextPath}/upload-file" enctype="multipart/form-data">
			  <!-- File input -->    
			  <input name="file2" id="file2" type="file" /><br/>
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form> 
	</c:if>
	<button value="Submit" onclick="uploadJqueryForm()" >Upload</button><i>Using JQuery Form Plugin</i><br/>
<button value="Submit" onclick="uploadFormData()" >Upload</button><i>Using FormData Object</i>
 
<div id="result"></div>
</body>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://malsup.github.com/jquery.form.js"></script>
<script type="text/javascript">
$(function () {
    var token = $("input[name='_csrf']").val();
    var header = "X-CSRF-TOKEN";
    $(document).ajaxSend(function(e, xhr, options) {
    	debugger;
        xhr.setRequestHeader(header, token);
    });
});
//using jquery.form.js
function uploadJqueryForm(){
    $('#result').html('');
 
   $("#form2").ajaxForm({
    success:function(data) { 
          $('#result').html(data);
     },
     dataType:"text"
   }).submit();
}
</script>
</html>