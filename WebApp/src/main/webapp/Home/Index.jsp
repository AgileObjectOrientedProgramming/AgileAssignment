<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>


<h1 class="display-1 center">ForYouShipment</h1>
<br>
<br>

<div class="card text-center">
    <div class="card-body">
        <p class="card-text"> Logistics Company in charge of your company orders
            <br>
        </p>
    </div>
</div>

<br>
<div class="row" style="display: flex; flex-wrap: wrap">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Our partner companies</h5>
        <p class="card-text">As a company client you have access to a personalised account, 
                where you can manage your orders. Each order has a unique Shipment ID, which 
                can be shared with your own customers. </p>
        <a href="/UserManual" class="btn btn-primary">User Manual</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Our Team</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">About us</a>
      </div>
    </div>
  </div>
</div>

<br>
<br>
<br>
<br>
<br>
<br>
<div style="display: flex;
            flex-wrap: nowrap;
            padding: 10px;"
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
        window.location.href = "/Journey/View?ID=" + button_content;
    }
</script>


<style>
    .body {
        background-image: url("https://images.unsplash.com/photo-1558566455-b62dfa3e19a6?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1589&q=80");
    } 
    .card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        margin: auto;
        width: 70%;
        backdrop-filter: blur(10px);
        border-radius: 10px;
    }
    .main-card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
        border-radius: 10px;
    }
    .center {
        color: white;
        margin: auto;
        width: 35%;
        height: 50%;
        padding-top: 2.5%;
    }
</style>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>
