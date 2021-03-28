<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"></jsp:include>

<div  style="width: 80%;">
    <c:if test="${warning != null}">
        <div class="alert alert-danger" role="alert">
            ${warning}
        </div>
    </c:if>

    <form action="/Signup/Index" method="post" class="card">
        <div class="card-header">
            <h5>Create New User</h5>
        </div>
        <div class="card-body">
            <label for="FirstName">First Name:</label>
            <br>
            <input type="text" class="form-control" name="FirstName" required>
            </br>
            <label for="LastName">Last Name:</label>
            <br>
            <input type="text" class="form-control" name="LastName" required>
            <br>
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Submit">
            <a class="btn btn-danger" href="/Users/Index">Cancel</a>
        </div>
    </form>
</div>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>