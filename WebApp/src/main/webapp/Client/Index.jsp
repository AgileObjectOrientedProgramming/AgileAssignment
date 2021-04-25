<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>

<div class="main-card">
    <h1 class="display-5 center">Welcome to the Client Page! </h1>
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
</style>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

