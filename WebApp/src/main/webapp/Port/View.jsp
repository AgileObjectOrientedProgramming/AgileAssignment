<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>


<div class=main-card>

</div>
<h2>Containers at port ${Port.toString()}</h2> 

<form action="/Port/NewContainer?Port=${Port.toString()}" method="post" style="display:flex;">
    <input type="number" value="1" class="form-control" name="Count">
    <input type="submit" class="btn btn-success" value="Add New Container" style="margin-left: 5px"> 
</form> 
<br>
<br>

<br>

<table class="table table-hover" >
<thead class="thead-light" >
    <tr>
        <th>ID</th>
        <th>History Count</th>
    </tr>
</thead>
<tbody>
    <c:forEach items="${Containers}" var="element">
         <tr style='cursor: pointer; cursor: hand;' onclick="window.location='/Container/View?ID=${element.getId()}';">
            <td>${element.getId()} </td>
            <td>${element.getJourneyHistory().size()} </td>
        </tr>   
    </c:forEach>
</tbody>
</table>


<style>
    .body {
        background-image: url("https://images.pexels.com/photos/1655166/pexels-photo-1655166.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        width: 100;
        background-repeat: no-repeat;
        background-size: cover;
    } 
    .thead-light {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(20px);
    }
    .table-hover {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
    }
</style>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>