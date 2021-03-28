<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="TopBarUsername" value="${client.getUsername()}"/>
</jsp:include>



<h2>Welcome ${client.GenerateName()}!</h2> 


<h4>
    This is your wall senpai :3!
</h4>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

