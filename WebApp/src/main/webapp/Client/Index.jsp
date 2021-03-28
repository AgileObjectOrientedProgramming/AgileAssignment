<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="TopBarUsername" value="${client.getUsername()}"/>
</jsp:include>



<h3>Welcome ${client.GenerateName()}!</h3> 


<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

