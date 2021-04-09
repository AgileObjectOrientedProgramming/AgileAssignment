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

    <form action="/Journey/New" method="post" class="card">
        <div class="card-header">
            <h5>Register new container</h5>
        </div>
        <div class="card-body">
            <label for="Origin">Origin:</label>
            <br>
            <input type="text" class="form-control" name="Origin" value required>
            <br>
            <label for="Destination">Destination:</label>
            <br>
            <input type="text" class="form-control" name="Destination" value required>
            <br>
            <label for="Company">Company:</label>
            <br>
            <input type="text" class="form-control" name="Company" value required>
            <br>
            <label for="Content type">Content type</label>
            <br>
            <select id="Content type" name="Content type" class='form-control' value>
                <option value="Fragile">Fragile</option>
                <option value="Flamable">Flamable</option>
                <option value="Standard">Standard</option>
                <option value="Emma">Emma</option>
              </select>
              
        </div>    
        <div style="display: flex; justify-content: space-between;" class="card-footer">
            <input type="submit" class="btn btn-success" value="Submit">
            <a class="btn btn-danger" href="/Journey">Cancel</a>
        </div>
    </form>
</div>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>