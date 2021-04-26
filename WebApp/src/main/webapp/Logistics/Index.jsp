<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>


<h2 class="display-1">Welcome to the Logistics Board!</h2> 
<br>

<!-- <div class="card">
    <div class="card-body">
      <h5 class="card-title">Important Statistics</h5>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Number of clients: ${numberClients}</li>
            <li class="list-group-item">Number of journeys: ${numberJourneys}</li>
            <li class="list-group-item">Number of containers</li>
            <li class="list-group-item">Number of ports</li>
            </ul>
      <a class="btn btn-success" href="/Signup">
        Add Client
        </a>
    </div>
  </div>
  -->

<div class="main-card">
    <div class="card-body">
        <h2 class="card-title">Important Statistics</h3>
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#home">Clients</a></li>
            <li><a data-toggle="tab" href="#menu1">Journeys</a></li>
            <li><a data-toggle="tab" href="#menu2">Containers</a></li>
          </ul>
          
          <div class="tab-content">
            <div id="home" class="tab-pane fade in active">
              <h3>Client Management</h3>
              <p>Some content.</p>
                <a class="btn btn-success" href="/Signup">
                    Add Client
                </a>
            </div>
            <div id="menu1" class="tab-pane fade" color="white">
              <h3>Journey Management</h3>
              <p>Some content in menu 1.</p>
            </div>
            <div id="menu2" class="tab-pane fade">
              <h3>Container Management</h3>
              <p>Some content in menu 2.</p>
            </div>
            
          </div>
    </div>
</div>


<style>
    .body {
        background-image: url("https://images.unsplash.com/photo-1573030889348-c6b0f8b15e40?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1613&q=80");
        width: 100;
        background-repeat: no-repeat;
        background-size: cover;
    } 
    .main-card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
        border-radius: 10px;
        width: 70%;
        margin: auto;
    }
    .list-group-item {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
    }
    a {
        color: #e9ecef;
        text-decoration: none;
    }
    a {
        background-color: rgb(255 255 255 / 15%);
    }
    h2 { text-align: center }
</style>





<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

