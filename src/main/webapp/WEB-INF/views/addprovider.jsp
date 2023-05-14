<%@ include file="includes/header.jspf" %>
<%@ include file="includes/navbar.jspf" %>
<body>
<div class="container">
<h1>add a provider</h1>
<form:form action="saveprovider" method="POST" modelAttribute="provider">
<table>
<tr>
<td>Name</td>
<td><form:input path="name"/></td>
</tr>
<tr>
<td>
<form:errors path="name" cssClass="text-danger" />
</td>
</tr>
<tr>
<td>SurName</td>
<td><form:input path="surname"/></td>
</tr>
<tr>
<td>
<form:errors path="surname" cssClass="text-danger" />
</td>
</tr>
<tr>
<td>Phone</td>
<td><form:input path="phone"/></td>
</tr>
<tr>
<td>
<form:errors path="phone" cssClass="text-danger" />
</td>
</tr>
<tr>
<td>Adress</td>
<td><form:input path="adress"/></td>
</tr>
<tr>
<td>
<form:errors path="Adress" cssClass="text-danger" />
</td>
</tr>



<tr>
<td>Active</td>
<td><select name="active">
<option value="false">false</option>
<option value="true">true</option>
</select></td>
</tr>




<tr>
<td><a class="btn btn-outline-secondary" href="providers" role="button">back</a></td>
<td>
<input type="submit" class="btn btn-outline-success" value="save provider" />
</td></tr>

</table>


</form:form>
</div>
<%@ include file="includes/footer.jspf" %>