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
              <p>As a logistic user, you have the ability to sign-up clients, by creating a username and password for them.
                <br>
                <br>
                Once they log in on the system, they can update their profile information even further.
                <br>
                <br>
                You have the ability to view any client profile, as well as delete any client, but you are not allowed
                    to change their personal information, nor modify their username or password.
                <br>
                <br>
                The search engine allows you to find any client by any criteria, eg. username.
                <br>
                <br>
                Number of clients: ${numberClients}
              </p>
              <div style="display: flex; justify-content:flex-start ;">
                <a class="btn btn-success" href="/Signup" style="margin-right: 30px"> Add new Client</a>
                <a class="btn btn-info" href="/Client/Search"> Search Clients</a>
              </div>
            </div>
            <div id="menu1" class="tab-pane fade" color="white">
              <h3>Journey Management</h3>
              <p>As a logistic user, you have the ability to accept any Journey request made by the clients.
                <br>
                <br>
                Once the Journey is accepted, both the logistics user and the client user can track its history 
                    on the World Map. 
                <br>
                <br>
                The search engine allows you to find any journeys by any criteria, eg. destination port.
                <br>
                <br>
                Everytime a client creates a new Journey, you will get a little notification on the button bellow
                <br>
                <br>
                Number of active journeys: ${numberAprovedJourneys}
              </p>
              <div style="display: flex; justify-content:flex-start ;">
                <a type="button" class="btn btn-info" href="/Journey/Search">
                  Journeys <span class="badge bg-secondary">${numberJourneysToApprove}</span>
                </a>
              </div>
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

