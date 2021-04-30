<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp">
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>

<div  style="width: 80%;">
    <c:if test="${warning != null}">
        <div class="alert alert-danger" role="alert">
            ${warning}
        </div>
    </c:if>

    <form action="/Journey/Measurements" method="post" class="card">
        <div class="card-header">
            <h3>Set container measurements </h3>
        </div>
        
        <div class="card-body"> 
            <c:forEach items="${Container.getAllParameters()}" var="element">
                <c:if test="${!element.equals('JourneyID')}">
                        <label for="element">${element} </label>
                        <br>
                        <input type="text" class="form-control" name="${element}" value required>
                    <br>
                </c:if>
            </c:forEach>
            <input type = "hidden" name ="ContainerID" value = "${ContainerID}">
            <input type = "hidden" name ="JourneyID" value = "${Container.getJourney().getId()}">
            <label for="ReachedDestination">Reached Destination Port</label>
            <select name="ReachedDestination" class="form-control">
                <option value="Yes">Yes</option>
                <option value="No">No</option>
            </select>
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Submit">
            <a class="btn btn-danger" href="/Journey/Search">Cancel</a>
        </div>
    </form>
</div>

<style>
    .card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        margin: auto;
        width: 80%;
        backdrop-filter: blur(10px);
        margin-bottom: 10px;
    }
  .body {
        background-image: url("https://images.pexels.com/photos/234272/pexels-photo-234272.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        width: 100;
        background-repeat: no-repeat;
        background-size: cover;
    }
    h1 { text-align: center }
</style>


<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>