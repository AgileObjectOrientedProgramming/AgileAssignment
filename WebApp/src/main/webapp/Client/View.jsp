<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>



<h2>${ProfileUser.getUsername()}'s Profile</h2> 

<ul class="list-group"  >
    <c:forEach items="${ProfileUser.getProfile().getAllParameters()}" var="element">
        <li class="list-group-item">
            ${element}:${ProfileUser.getProfile().getParameter(element)}
        </li>   
    </c:forEach>
</ul>

<c:if test="${SignedUser == ProfileUser}">
    <a href="/Client/Edit" class="btn btn-success">Edit Profile</a>
</c:if>

<style>
    .body {
        background-image: url("https://images.pexels.com/photos/1103970/pexels-photo-1103970.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        width: 100;
        background-repeat: no-repeat;
        background-size: cover;
        
    } 
    .card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        margin: auto;
        width: 70%;
        backdrop-filter: blur(10px);
        border-radius: 10px;
    }
    .main-card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
        border-radius: 10px;
    }
    .center {
        color: white;
        margin: auto;
        width: 35%;
        height: 50%;
        padding-top: 2.5%;
    }
</style>


<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

