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

    <form action="/Container/New" method="post" class="card">
        <div class="card-header">
            <h5>Container status</h5>
        </div>
        <div class="card-body">
            <label for="temperature">Internal temperature [&#8451]</label>
            <br>
            <input type="number" class="form-control" name="temperature" value required step="any">
            <br>
            <label for="humidity">Air humidity [%]</label>
            <br>
            <input type="number" class="form-control" name="humidity" value required step="any">
            <br>
            <label for="pressure">Atmospheric pressure [Pa]</label>
            <br>
            <input type="number" class="form-control" name="pressure" value required step="any">
              
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Submit">
            <a class="btn btn-danger" href="/">Cancel</a>
        </div>
    </form>
</div>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>