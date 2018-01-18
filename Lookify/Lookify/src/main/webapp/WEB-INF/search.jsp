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
        Songs by artist: <c:out value="${lookify.get(0).getArtist()}"/><br>
        <input type="text" name="search">
        <input type="submit" value="Search Artists"><br><br>
        <a href="/dashboard">Dashboard</a>
        <h1>SUCCESS</h1>
        <table>
            <tr>
                <th>Title</th>
                <th>Rating</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${lookify}" var="song"  varStatus="loop">
            <tr>
                <td><a href="/display/${song.id}"><c:out value= "${song.title}"/></a></td>
                <td><c:out value= "${song.rating}"/></td>
                <td><a href="/delete/${song.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </table>

	</body>
</html>