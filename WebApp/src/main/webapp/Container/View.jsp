<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>


<div class=main-card>

</div>
<h2>Container #${Container.getId()}</h2> 

<form action="/Container/Delete?ID=${Container.getId()}" method="post" style="display:flex; justify-content: flex-end;">
    <c:if test="${Container.getJourney() == null}">
        <input type="submit" class="btn btn-danger btn-lg float-end" value="Delete Container" style="margin-right: 5px"> 
    </c:if>
    <a class="btn btn-info btn-lg float-end" href="/Port/View?Port=${Container.getLocation().toString()}"> Back </a>   
</form>

<br>
<br>

<div class="panel-group" id="accordion">

    <c:forEach items="${Container.getJourneyHistory()}" var="journey">
        <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
            From ${journey.getOrigin().toString()} to ${journey.getDestination().toString()} ordered by ${journey.getParameter("Username")}: Journey ID #${journey.getId()}</a>
            </h4>
        </div>
        <div id="collapse1" class="panel-collapse collapse in">
            <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
            minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
            commodo consequat.</div>
        </div>
        </div>
    </c:forEach>
</div>


<style>
    .panel-group {
        color:white;
        border-radius: 10px;
        width: 100%;
        margin: auto;
    }
    .panel-default {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
        border-radius: 10px;
        width: 100%;
        margin: auto;
    }
    .panel-heading {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
        width: 100%;
        margin: auto;
    }
    .body {
        background-image: url("https://images.pexels.com/photos/2850287/pexels-photo-2850287.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260");
        width: 100;
        background-repeat: no-repeat;
        background-size: cover;
    } 
    .thead-light {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(20px);
    }
    .table-hover {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
    }
    h2 { color:white; text-align: center }
</style>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>
