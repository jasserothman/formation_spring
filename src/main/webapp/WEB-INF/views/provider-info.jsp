<%@ include file="includes/header.jspf" %>
<%@ include file="includes/navbar.jspf" %>
<body>
<h1>update provider</h1>
<form:form   modelAttribute="providers">
<table>
<tr>

<td>providerNumber<input type="hidden" id="fname"name="id" value="${provider.id}" ></td>

</tr>
<tr>


<td>Name</td>
<td><form:input path="name"/></td>
</tr>
<tr>
<td>SurName</td>
<td><form:input path="surname"/></td>
</tr>
<tr>
<td>Phone</td>
<td><form:input path="phone"/></td>
</tr>
<tr>
<td>Adress</td>
<td><form:input path="adress"/></td>
</tr>
<tr>
<td>Active</td>
<td><form:input path="active"/></td>
</tr>

<tr>

<td><a class="btn btn-outline-secondary" href="products" role="button">back</a></td>
</tr>

</table>

</form:form>
<%@ include file="includes/footer.jspf" %>