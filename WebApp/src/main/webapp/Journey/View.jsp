<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>



<h2>Your Journey information</h2> 



<c:if test="${SignedUser.IsLogisticUser()}">
<a class="btn btn-warning btn-lg float-end" submit="${Journey.setStatus('Active')}" onclick="window.confirm('Are you sure you want to confirm the journey');">
    Confirm Shipment
</a>
<a class="btn btn-warning btn-lg float-end" href="/Journey/Measurements?ID=${ContainerID}" >
    Set Measurements
</a>
</c:if>

 
From "${Journey.getOrigin().toString()} " to "${Journey.getDestination().toString()} "

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

