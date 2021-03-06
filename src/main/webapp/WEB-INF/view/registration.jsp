<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
	<jsp:include page="header.jsp" />
	<form:form method = "POST" modelAttribute = "tmpUser" action = "processingRegistration">
    <table>
        <tr>
           <td><form:label path = "name">ім'я'*</form:label></td>
           <td><form:input path = "name" /></td>
           <td><form:errors path="name"/></td>
        </tr>
        <tr>
           <td><form:label path = "surname">прізвище *</form:label></td>
           <td><form:input path = "surname" /></td>
           <td><form:errors path="surname"/></td>
        </tr>
        <tr>
           <td><form:label path = "phone">телефон*</form:label></td>
           <td><form:input path = "phone" /></td>
           <td><form:errors path="phone"/></td>
        </tr>
        <tr>
           <td><form:label path = "eMail">eMail*</form:label></td>
           <td><form:input path = "eMail" /></td>
           <td><form:errors path="eMail"/></td>
        </tr>
        <tr>
           <td><form:label path = "address">адреса</form:label></td>
           <td><form:input path = "address" /></td>
           <td><form:errors path="address"/></td>
        </tr>
        <tr>
           <td><form:label path = "password">пароль*</form:label></td>
           <td><form:input path = "password" /></td>
           <td><form:errors path="password"/></td>
        </tr>
        <tr>
           <td><form:label path = "confirmPassword">підтвердити пароль*</form:label></td>
           <td><form:input path = "confirmPassword" /></td>
           <td></td>
        </tr>
        <tr>
           <td colspan = "3" style="color:red">CAPCHA</td>
        </tr>
        <tr>
           <td colspan = "3">поля позначені * мають бути обов'язково заповнені</td>
        </tr>
        <tr>
           <td colspan = "3">номер телефону буде використано як логін при авторизації</td>
        </tr>

        <tr>
           <td colspan = "3">
              <input type = "submit" value = "Submit"/>
           </td>
        </tr>
    </table>
    </form:form>
	<jsp:include page="footer.jsp" />