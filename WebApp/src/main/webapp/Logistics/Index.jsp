<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>


<h2 lass="display-1">Welcome to the Logistics Board!</h2> 

<br>
<br>

<ul>
    <c:forEach items="${SignedUser.getProfile().getAllParameters()}" var="element">
        <li>
            ${element}: ${SignedUser.getProfile().getParameter(element)}
        </li>   
    </c:forEach>
</ul>

<br>
<br>

<div class="card">
    <div class="card-body">
      <h5 class="card-title">Important Statistics</h5>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Number of clients:</li>
            <li class="list-group-item">Number of journeys</li>
            <li class="list-group-item">Number of containers</li>
            <li class="list-group-item">Number of ports</li>
            </ul>
      <a class="btn btn-success" href="/Signup">
        Add Client
        </a>
    </div>
  </div>





<style>
    .body {
        background-image: url("https://images.unsplash.com/photo-1573030889348-c6b0f8b15e40?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1613&q=80");
    } 
    .card {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
        backdrop-filter: blur(10px);
        border-radius: 10px;
    }
    .list-group-item {
        background-color: rgba(0, 0, 0, 0.2);
        color:white;
    }
</style>



<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

