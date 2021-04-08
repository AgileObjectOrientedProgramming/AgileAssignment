<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
    <jsp:param name="Ownjourneys" value="${Ownjourneys}"/>

</jsp:include>



<h2>Journey Management</h2> 

<ul>
    <c:forEach items="${Ownjourneys}" var="element">
        <li>
            From ${element.getOrigin()} to ${element.getDestination()}
            </br>
            Content type: ${element.getContent_type()}
        </li>   
    </c:forEach>
</ul>



<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

