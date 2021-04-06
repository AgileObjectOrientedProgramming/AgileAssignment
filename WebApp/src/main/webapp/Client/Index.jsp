<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>



<h2>Welcome to the client board!</h2> 

<ul>
    <c:forEach items="${User.getProfile().getAllParameters()}" var="element">
        <li>
            ${element}: ${User.getProfile().getParameter(element)}
        </li>   
    </c:forEach>
</ul>

<a class="btn" href="/Client/View?ID=${User.getID()}">
    Go to Profile
</a>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

