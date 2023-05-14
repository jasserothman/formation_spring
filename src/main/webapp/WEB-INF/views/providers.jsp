<%@ include file="includes/header.jspf" %>
<%@ include file="includes/navbar.jspf" %>
<body>
<h1>Providers</h1>
<div class="container">

<a class="btn btn-outline-primary"  href="/formation/addprovider">add provider</a>
</div>
<br>
<div class="container">


<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">id</th>
      <th scope="col">name</th>
      <th scope="col">surname</th>
      <th scope="col">phone</th>
         <th scope="col">adress</th>
          <th scope="col">active</th>
          <th scope="col">Option</th> 
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${providers}" var="prov">
	<tr >
      <th scope="row">${prov.id}</th>
      <td> ${prov.name} </td>
      <td> ${prov.surname} </td>
     <td> ${prov.phone} </td>
       <td> ${prov.adress} </td>
       <td> ${prov.active} </td>
      
       <td> <a href="edit?id=<c:out value='${prov.id}'/>" class="btn btn-outline-info">Update</a>
          <a href="delete?id=<c:out value='${prov.id}'/>" class="btn btn-outline-warning">Delete</a></td>
       
   
    </tr>
  </c:forEach>
  </tbody>
</table>


</div>

<%@ include file="includes/footer.jspf" %>