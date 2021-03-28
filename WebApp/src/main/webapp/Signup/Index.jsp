<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"></jsp:include>

<div  style="width: 80%;">
    <c:if test="${warning != null}">
        <div class="alert alert-danger" role="alert">
            ${warning}
        </div>
    </c:if>

    <form action="/Signup/CreateUser" method="post" class="card">
        <div class="card-header">
            <h5>Create New User</h5>
        </div>
        <div class="card-body">
            <label for="FirstName">First Name:</label>
            <br>
            <input type="text" value="${FirstName}" class="form-control" name="FirstName" required>
            </br>
            <label for="LastName">Last Name:</label>
            <br>
            <input type="text" value="${LastName}" class="form-control" name="LastName" required>
            <br>
            <label for="Username">Username:</label>
            <br>
            <input type="text" value="${Username}" class="form-control" name="Username" required>
            <br>
            <label for="Password">Password:</label>
            <br>
            <input type="password" class="form-control" name="Password" required>
            <br>
            <label for="PasswordRetype">Retype Password:</label>
            <br>
            <input type="password" class="form-control" name="PasswordRetype" required>
            <br>
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Submit">
            <a class="btn btn-danger" href="/Users/Index">Cancel</a>
        </div>
    </form>
</div>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>