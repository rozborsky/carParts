<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="header.jsp" />
	<div class="row">
    	<div class="col-12" id="aboutMe">


			<form name="form_login" action="<c:url value='/login' />" method="POST">
			<c:if test="${not empty error}">
                ${error}
            </c:if>
			<table>
                <tr>
                    <td>User:</td>
                    <td><input type="text" name="user_login" value=""></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password_login"></td>
                </tr>
                <tr>
                    <td>Remember me:</td>
                    <td><input type="checkbox" name="rememberMe"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="submit"></td>
                </tr>
                    <input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}"/>
                <tr>
            </table>root123
		</div>
	</div>
	<jsp:include page="footer.jsp" />