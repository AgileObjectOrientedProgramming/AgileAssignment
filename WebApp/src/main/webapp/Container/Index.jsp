<!-- the status in Journey page can be a buttom leading to container page -->
<!-- this page is the container page -->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
    <jsp:param name="Owncontainers" value="${Owncontainers}"/>

</jsp:include>



<h2>Container Status</h2> 

<a class="btn btn-info btn-lg float-end" href="/Container/Search" >
    Search
</a>


<h2>Container List</h2> 

<br>

<table class="table table-hover" >
<thead class="thead-light" >
    <tr>
        <th> Internal temperature [&#8451] </th>
        <th> Air humidity [%] </th>
        <th> Atmospheric pressure [Pa] </th>
    </tr>
</thead>
<tbody>
    <c:forEach items="${Owncontainers}" var="element">
        <tr>
            <td>${element.getTemperature().toString()} </td>
            <td>${element.getHumidity().toString()} </td>
            <td>${element.getPressure().toString()}</td>
        </tr>   
    </c:forEach>
</tbody>
</table>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>