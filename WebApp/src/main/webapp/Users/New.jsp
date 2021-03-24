<jsp:include page="../Shared/MainLayoutTop.jsp"></jsp:include>



<form action="/Users/New" method="post" style="width: 80%;" class="card">
    <div class="card-header">
        <h5>Create New User</h5>
    </div>
    <div class="card-body">
        <label for="FirstName">First Name:</label>
        <br>
        <input type="text" class="form-control" name="FirstName">
        </br>
        <label for="LastName">Last Name:</label>
        <br>
        <input type="text" class="form-control" name="LastName">
        <br>
    </div>    
    <div style="display: flex; justify-content: space-between;" class="card-footer">
        <input type="submit" class="btn btn-success" value="Submit">
        <a class="btn btn-danger" href="/Users/Index">Cancel</a>
    </div>
</form>


<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>