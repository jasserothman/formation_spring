<%@ include file="includes/header.jspf" %>
<%@ include file="includes/navbar.jspf" %>
<body>
<h1>Products</h1>
<div class="container">

<a class="btn btn-outline-primary"  href="/formation/addproduct">add product</a>
</div>
<br>
<div class="container">

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">id</th>
      <th scope="col">name</th>
      <th scope="col">quantity</th>
      <th scope="col">description</th>
        <th scope="col">isOnSell</th>
          <th scope="col">isAvailable</th>
 <th scope="col">provider_id</th>
        <th scope="col">Option</th> 
   
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${products}" var="prod">
	<tr >
      <th scope="row">${prod.id}</th>
      <td> ${prod.name} </td>
      <td> ${prod.quantity} </td>
     <td> ${prod.description} </td>
     <td> ${prod.isOnSell} </td>
     <td> ${prod.isAvailable} </td>
      <td> ${prod.getProvider().getId()} 
      <a href="provider-info?id=<c:out value='${prod.getProvider().getId()}'/>" >show-info</a></td>
      
    
<%--       <a href="provider-info/<c:out value='${prod.getProvider().getId()}'/>" >show-info</a></td> --%>
      
      
       
      
       <td> <a href="edit-product?id=<c:out value='${prod.id}'/>" class="btn btn-outline-info">Update</a>
          <a href="delete/<c:out value='${prod.id}'/>" class="btn btn-outline-warning">Delete</a></td>
       
   
    </tr>
  </c:forEach>
  </tbody>
</table>


</div>

<%@ include file="includes/footer.jspf" %>