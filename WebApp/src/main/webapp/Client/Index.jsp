<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>

<h2 class="display-1">Welcome to the Client Board!</h2> 
<br>

<div class="main-card">
    <div class="card-body">
        <h2 class="card-title">How to Use</h3>
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#home">General</a></li>
            <li><a data-toggle="tab" href="#menu1">Journeys</a></li>
          </ul>
          
          <div class="tab-content">
            <div id="home" class="tab-pane fade in active">
              <h3>General Information</h3>
              <p>Having an account on this website gives you the possibility to request orders and the logsitcs company will
                    take care of them, keeping you up-to date with the latest changes to your order.
                <br>
                <br>
                As a client user, you have the ability to view your profile, aswell as update your personal details.
                <br>
                <br>
                You have the ability to view any client profile, as well as delete any client, but you are not allowed
                    to change their personal information, nor modify their username or password.
                <br>
                <br>
                The search engine allows you to find any client by any criteria, eg. username.
              </p>
              <div style="display: flex; justify-content:flex-start ;">
                <a class="btn btn-success" href="/Client/View?ID=${SignedUser.getID()}" style="margin-right: 30px"> View your profile</a>
              </div>
            </div>
            <div id="menu1" class="tab-pane fade" color="white">
              <h3>Orders</h3>
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
                Available ports:
                <ul>
                    <!-- <c:if test="${!element.getKey().equals('In Transit')}">
                    <a class="btn btn-primary" style="margin: 10px;" 
                      href='/Port/View?Port=${element.getKey()}'>
                      ${element.getKey()} <span class="badge bg-info text-dark">${element.getValue()}</span>
                    </a>
                  </c:if> -->
                </ul>
              </p>
            </div>
    </div>
</div>


<style>
    .body {
        background-image: url("https://images.pexels.com/photos/7634552/pexels-photo-7634552.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        width: 100;
        background-repeat: no-repeat;
        background-size: cover;
        
    } 
    .main-card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        margin: auto;
        width: 70%;
        backdrop-filter: blur(10px);
        border-radius: 10px;
    }
    .center {
        color: white;
        margin: auto;
        width: 50%;
        height: 50%;
    }
    .jumbotron {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        margin: auto;
        width: 70%;
        backdrop-filter: blur(10px);
        border-radius: 10px;
    }
    h2 { text-align: center }
</style>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

