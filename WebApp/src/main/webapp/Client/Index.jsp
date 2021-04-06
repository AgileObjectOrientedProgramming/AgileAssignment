<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="TopBarUsername" value="${Username}"/>
</jsp:include>



<h2>Welcome!</h2> 

<ul>
    <c:forEach items="${Profile.getAllParameters()}" var="element">
        <li>
            ${element}: ${Profile.getParameter(element)}
        </li>   
    </c:forEach>
</ul>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

