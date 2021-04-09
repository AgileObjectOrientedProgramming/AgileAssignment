<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>



<h2>Search all your clients</h2> 

<form action="/Client/Search" method="get" style="display:flex; width: 80%;">
    <input type="text" class="form-control" name="Query" value="${Query}">
    <input type="submit" class="btn btn-success" value="Search" style="margin-left: 5px"> 
</form>

<br>
<br>

<div style="display: flex; flex-wrap: wrap">
    <c:forEach items="${answer}" var="element">
        <div class="card" style="width: 300px; margin: 20px">
            <div class="card-header">User</div>
            <div class="card-body">${element.getUsername()}</div>
            <div style="display: flex; justify-content: space-between;" class="card-footer">
                <a href="/Client/View?ID=${element.getID()}" class="btn btn-success">View Profile</a>
                <a href="/Client/Delete?ID=${element.getID()}" class="btn btn-danger">Delete User</a>
            </div>
        </div>
    </c:forEach>
</div>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

