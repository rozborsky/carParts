<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<html>
	<head>
		<title>shop</title>

 		<meta charset="utf-8">
     	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="webjars/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" rel="stylesheet">
        <link rel="shortcut icon" href='<c:url value="/resources/images/favicon.png" />' type="image/x-icon">
        <style>
			<%@include file='styles.css'%>
        </style>


	</head>
	<body>
		<div class="container" id="mainLayout">
		    <div class="col-12" id="header">
		        <ul class="nav navbar-nav navbar-right">
                    <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    <li><a href="registration"><span class="glyphicon glyphicon-user"></span>реєстрація</a></li>
                    <sec:authorize access="isAuthenticated()">
                        <li><c:url var="logoutUrl" value="/logout"/>
                            <form action="${logoutUrl}" method="post">
                                <input type="submit" value="Logout"/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </li>
                    </sec:authorize>
                </ul>
		    </div>
