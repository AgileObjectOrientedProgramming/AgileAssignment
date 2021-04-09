<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>



<h2>Welcome to the Logistics Board!</h2> 

<ul>
    <c:forEach items="${SignedUser.getProfile().getAllParameters()}" var="element">
        <li>
            ${element}: ${SignedUser.getProfile().getParameter(element)}
        </li>   
    </c:forEach>
</ul>

<a class="btn btn-success" href="/Signup">
    Add Client
</a>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

