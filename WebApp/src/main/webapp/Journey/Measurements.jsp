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
            <h3>Set container Measurements </h3>
        </div>
        
        <div class="card-body"> 
            <c:forEach items="${Container.getAllParameters()}" var="element">
                <label for="element">${element} </label>
                <br>
                <c:choose>
                    <c:when test="${element=='Time'}">
                        <input type="date">
                        <br>
                    </c:when>
                    <c:otherwise >
                        <input type="text" class="form-control" name="${element}" value required>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <input type = "hidden" name ="ContainerID" value = "${ContainerID}">
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Submit">
            <a class="btn btn-danger" href="/">Cancel</a>
        </div>
    </form>
</div>



<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>