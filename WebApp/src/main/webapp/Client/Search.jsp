<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>



<h2>Search all your clients</h2> 

<form action="/Client/Search" method="get" style="display:flex;">
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

<style>
    .body {
        background-image: url("https://images.unsplash.com/photo-1573030889348-c6b0f8b15e40?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1613&q=80");
        width: 100;
        background-repeat: no-repeat;
        background-size: cover;
    } 
    .card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
        border-radius: 10px;
    }
</style>


<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

