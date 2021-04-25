<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>

<h1 class="display-1 center">Our Team</h1>

<div class="card" style="width: 300px; margin: 20px">
  <img src="/dario.jfif" alt="Dario" style="width:40%" class="center"   >
  <h2>Dario</h2>
  <p class="title">CEO & Founder, Example</p>
  <p>Harvard University</p>
</div>

<div style="display: flex; flex-wrap: wrap">
  
  <div class="card" style="width: 300px; margin: 20px">
      <div class="card-header">Logsistics User</div>
      <div class="card-body">You have the ability of signing-up new clients and you can view any journey.</div>
  </div>
  <div class="card" style="width: 300px; margin: 20px">
    <div class="card-header">Client User</div>
    <div class="card-body">You have the ability to make new journey requests.</div>
  </div>
  <div class="card" style="width: 300px; margin: 20px">
    <div class="card-header">Add new Journey</div>
    <div class="card-body">As a client you can request a journey from thr available ports</div>
  </div>
</div>


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
