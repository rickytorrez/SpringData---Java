<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h2>Language Information</h2>
		<h3>Language Name: </h3><c:out value="${languages.name}"/>
		<h3>Language Creator: </h3><c:out value="${languages.creator}"/>
		<h3>Language Version: </h3><c:out value="${languages.version}"/><br><br>
		<a href="/edit/${languages.id}">Edit</a>
		<a href="/delete/${languages.id}">Delete</a><br>
	</body>

</html>