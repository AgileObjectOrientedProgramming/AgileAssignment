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

    <form action="/Client/Edit" method="post" class="card">
        <div class="card-header">
            <h5>Edit your Profile</h5>
        </div>
        <div class="card-body">
            <c:forEach items="${SignedUser.getProfile().getAllParameters()}" var="element">
                <label for="${element}">${element}:</label>
                <br>
                <input type="text" class="form-control" name="${element}" value="${SignedUser.getProfile().getParameter(element)}" >
                <br>
            </c:forEach>
            <label for="Password">Password:</label>
            <br>
            <input type="password" class="form-control" name="Password">
            <br>
            <label for="PasswordRetype">Retype Password:</label>
            <br>
            <input type="password" class="form-control" name="PasswordRetype">
            <br>
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Submit">
            <a class="btn btn-danger" href="/Client/View?ID=${SignedUser.getID()}">Cancel</a>
        </div>
    </form>
</div>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>