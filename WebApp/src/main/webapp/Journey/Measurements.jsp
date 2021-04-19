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

    <form action="/Journey/Measurements" method="get" class="card">
        <div class="card-header">
            <h5>Container status</h5>
        </div>
        
        <div class="card-body"> 
            <c:forEach items="${c.getAllParameters()}" var="element">
                <li>
                    <span>
                        <label for="element">${"element"} </label>
                        <br>
                        <input type="number" class="form-control" name="element" value required step="any">
                    </span>
                </li>   
                <!-- <label for="element">${"element"} </label>
                <br>
                <input type="number" class="form-control" name="element" value required step="any"> -->
            </c:forEach>
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Submit">
            <a class="btn btn-danger" href="/">Cancel</a>
        </div>
    </form>
</div>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>