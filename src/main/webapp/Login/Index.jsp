<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"></jsp:include>

<div  style="width: 80%;">
    <c:if test="${warning != null}">
        <div class="alert alert-danger" role="alert">
            ${warning}
        </div>
    </c:if>

    <form action="/Login/New" method="post" class="card">
        <div class="card-header">
            <h5>Login</h5>
        </div>
        <div class="card-body">
            <label for="username">Username:</label>
            <br>
            <input type="text" class="form-control" name="username" required>
            </br>
            <label for="password">Password:</label>
            <br>
            <input type="password" class="form-control" name="password" required>
            <br>
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Login">
            <a class="btn btn-danger" href="/Users/Index">Cancel</a>
        </div>
    </form>
</div>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>