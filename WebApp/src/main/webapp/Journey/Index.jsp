<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
    <jsp:param name="Ownjourneys" value="${Ownjourneys}"/>

</jsp:include>



<h2>Journey Management</h2> 

<a class="btn btn-info btn-lg float-end" href="/Journey/New" >
    New Journey
</a>

<a class="btn btn-info btn-lg float-end" href="/Journey/Search" >
    Search
</a>


<h2>Journey List</h2> 

<br>

<table class="table table-hover" >
<thead class="thead-light" >
    <tr>
        <th> Origin </th>
        <th> Destination </th>
        <th> Content type </th>
        <th> Company </th>
        <th> Status </th>
    </tr>
</thead>
<tbody>
    <c:forEach items="${Ownjourneys}" var="element">
        <tr>
            <td>${element.getOrigin()} </td>
            <td>${element.getDestination()} </td>
            <td>${element.getContent_type()}</td>
            <td>${element.getCompany()} </td>
            <td>${element.getStatus()}</td>
        </tr>   
    </c:forEach>
</tbody>
</table>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

