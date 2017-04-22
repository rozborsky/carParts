<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<jsp:include page="header.jsp" />

    <h2>categories</h2>
    <table>
        <tr>
            <th>name</th>
            <th>image</th>
            <th>description</th>
            <th></th>
        </tr>

        <c:if test="${not empty categories}">
            <c:forEach var="category" items="${categories}">
                <tr>
                    <td>${category.getName()}</td>
                    <td>${category.getImage()}</td>
                    <td>${category.getDescription()}</td>
                    <td><a href="deleteCategory/${category.getName()}">delete</a></td>
                </tr>

            </c:forEach>
        </c:if>

        <tr>
            <form:form method = "POST" action = "manageCategories" modelAttribute="category">
                <td><form:input path = "name"/></td>
                <td><form:input path = "image"/></td>
                <td><form:input path = "description"/>
                <input type="submit" value="додати"/></td>
            </form:form>
        </tr>
    </table>
<jsp:include page="footer.jsp" />