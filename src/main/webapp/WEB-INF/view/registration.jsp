<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
	<jsp:include page="header.jsp" />
	<form:form method = "POST" modelAttribute = "registeredPerson" action = "processingRegistration">
    <table>
        <tr>
           <td><form:label path = "name">Name</form:label></td>
           <td><form:input path = "name" /></td>
        </tr>
        <tr>
           <td><form:label path = "surname">surname</form:label></td>
           <td><form:input path = "surname" /></td>
        </tr>
        <tr>
           <td><form:label path = "phone">phone</form:label></td>
           <td><form:input path = "phone" /></td>
        </tr>
        <tr>
           <td><form:label path = "eMail">eMail</form:label></td>
           <td><form:input path = "eMail" /></td>
        </tr>
        <tr>
           <td><form:label path = "address">address</form:label></td>
           <td><form:input path = "address" /></td>
        </tr>
        <tr>
           <td><form:label path = "password">password</form:label></td>
           <td><form:input path = "password" /></td>
        </tr>
        <tr>
           <td><form:label path = "confirmPassword">confirmPassword</form:label></td>
           <td><form:input path = "confirmPassword" /></td>
        </tr>

        <tr>
           <td colspan = "2">
              <input type = "submit" value = "Submit"/>
           </td>
        </tr>
    </table>
    </form:form>
	<jsp:include page="footer.jsp" />