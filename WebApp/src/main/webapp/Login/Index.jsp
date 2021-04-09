<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>

<div   >
    <c:if test="${warning != null}">
        <div class="alert alert-danger" role="alert">
            ${warning}
        </div>
    </c:if>

    <form action="/Login/Login" method="post" class="card">
        <div class="card-header">
            <h5>Login</h5>
        </div>
        <div class="card-body">
            <label for="Username">Username:</label>
            <br>
            <input type="text" class="form-control" name="Username" required>
            </br>
            <label for="Password">Password:</label>
            <br>
            <input type="password" class="form-control" name="Password" required>
            <br>
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Login">
            <a class="btn btn-danger" href="/">Cancel</a>
        </div>
    </form>
</div>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>