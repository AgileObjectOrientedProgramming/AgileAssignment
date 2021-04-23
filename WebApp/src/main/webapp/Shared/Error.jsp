<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>

<h1 class="display-1 center">Error 404: Not found :(</h1>

<style>
    .center {
        margin: auto;
        width: 50%;
        height: 50%;
        padding-top: 10%;
    }
</style>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>