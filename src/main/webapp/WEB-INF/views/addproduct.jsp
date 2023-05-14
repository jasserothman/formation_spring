<%@ include file="includes/header.jspf"%>
<%@ include file="includes/navbar.jspf"%>
<body>
	<div class="container">
		<h1>add a product</h1>
		<form:form action="saveproduct" method="POST" modelAttribute="product">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:errors path="name" cssClass="text-danger" /></td>
				</tr>
				<tr>
					<td>quantity</td>
					<td><form:input path="quantity" /></td>
				</tr>
				<tr>
					<td>description</td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td><form:errors path="description" cssClass="text-danger" />
					</td>
				</tr>

				<tr>
					<td>isOnSell</td>
					<td><select name="isOnSell">
							<option value="false">false</option>
							<option value="true">true</option>
					</select></td>
				</tr>


				<tr>
					<td>isAvailable</td>
					<td><select name="isAvailable">
							<option value="false">false</option>
							<option value="true">true</option>
					</select></td>
				</tr>


				<tr>
					<td>Fournisseur</td>
					<td><select name="id-provider">
							<c:forEach items="${providers}" var="provider">
								<option value="${provider.getId()}">${provider.name}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
			<td><a class="btn btn-outline-secondary" href="products" role="button">back</a></td>
					<td><input type="submit" class="btn btn-outline-success" value="save product" /></td>
				</tr>

			</table>

		</form:form>
	</div>
	<%@ include file="includes/footer.jspf"%></body>