<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>



<h2>${ProfileUser.getUsername()}'s Profile</h2> 

<ul>
    <c:forEach items="${ProfileUser.getProfile().getAllParameters()}" var="element">
        <li>
            ${element}: ${ProfileUser.getProfile().getParameter(element)}
        </li>   
    </c:forEach>
</ul>

<c:if test="${SignedUser == ProfileUser}">
    <a href="/Client/Edit" class="btn btn-success">Edit Profile</a>
</c:if>


<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

