<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>

<div class="card main-card">
    <div class="card-body">
        <div>Home</div>
        <h5 class="card-title">Our job</h5>
        <p class="card-text">We manage containers in a fun way! Just sign up and enjoy your stay with us!
            <br>
            Number of clients: 
        </p>
    </div>
</div>

<br>
<br>

<div style="display: flex;
            flex-wrap: nowrap;
            padding: 20px;"
        class="main-card">
    <div class="input-group" style="display: flex; flex-wrap: nowrap;">
        <span class="input-group-text" id="addon-wrapping">#</span>
        <input type="text" id="shipmentidinput" class="form-control"
                placeholder="Shipment ID" aria-label="Shipment ID"
                aria-describedby="addon-wrapping">
    </div>
    <button class="btn btn-success" onclick="GoToShimpentPage()"
            style="margin-left: 10px;">Search</button>
</div>

<script>
    function GoToShimpentPage() {
        var button_content = document.getElementById('shipmentidinput').value
        window.location.href = "/Journey/Search?id=" + button_content;
    }
</script>


<style>
    .body {
        background-image: url("https://images.pexels.com/photos/1095814/pexels-photo-1095814.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
    } 
    .main-card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
        border-radius: 10px;
    }
</style>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>
