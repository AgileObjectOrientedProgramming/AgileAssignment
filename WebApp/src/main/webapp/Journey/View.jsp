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


<c:if test="${!SignedUser.IsLogisticUser()}"> 
    <div style="white-space: pre;">
        <table class="table table-bordered table-dark" >
            <thead  >
                <tr>
                    <th> Time </th>
                    <th> Temperature </th>
                    <th> Pressure </th>
                    <th> Humidity </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${Measurements.getParameter('Time')} </td>
                    <td>${Measurements.getParameter('Temperature')} </td>
                    <td>${Measurements.getParameter('Pressure')}</td>
                    <td>${Measurements.getParameter('Humidity')} </td>    
                </tr>   
            </tbody>
            </table>
    </div>
</c:if>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

