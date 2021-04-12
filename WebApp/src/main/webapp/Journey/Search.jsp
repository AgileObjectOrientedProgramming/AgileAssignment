<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>



<h2>Search all your Journeys</h2> 

<form action="/Journey/Search" method="get" style="display:flex;">
    <input type="text" class="form-control" name="Query" value="${Query}">
    <input type="submit" class="btn btn-success" value="Search" style="margin-left: 5px"> 
</form>

<br>
<br>


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
            <th>        </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${Ownjourneys}" var="element">
            <tr>
                <td>${element.getOrigin().toString()} </td>
                <td>${element.getDestination().toString()} </td>
                <td>${element.getContent_type()}</td>
                <td>${element.getCompany()} </td>
                <td>${element.getStatus()}</td>
                <td><a class="btn btn-info float-end"  href="/Journey/View?ID=${Journey.getId()}">Open</a></td>
            </tr>   
        </c:forEach>
    </tbody>
</table>
<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

