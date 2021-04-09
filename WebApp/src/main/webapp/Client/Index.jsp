<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>

<div class="card bg-light mb-3"  >
    <div class="card-header">How to use the website</div>
    <div class="card-body">
    <h5 class="card-title"><h2>Welcome to the client board!</h2> </h5>
        <p class="card-text">You can view and edit your profile information as well as go back to the main page.</p>
  </div>

<a class="btn" href="/Client/View?ID=${User.getID()}">
    Go to Profile
</a>

<a class="btn" href="/Client/View?ID=${User.getID()}">
    Go to Profile
</a>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

