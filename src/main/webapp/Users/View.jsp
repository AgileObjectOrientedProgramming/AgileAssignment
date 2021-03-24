<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"></jsp:include>

<h1>
    List Of Registered Users:
</h1>

<style>
    .demo-list-icon {
      width: 300px;
    }
</style>

<ul class="demo-list-icon mdl-list">
    <c:forEach items="${users}" var="user">
        <li class="mdl-list__item">
            <span class="mdl-list__item-primary-content">
                <i class="material-icons mdl-list__item-icon">person</i>
                ${user.getFirstName()} ${user.getLastName()}
            </span>
        </li>   
    </c:forEach>
</ul>



<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>
