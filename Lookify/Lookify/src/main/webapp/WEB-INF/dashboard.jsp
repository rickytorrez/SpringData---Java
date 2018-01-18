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
        <a href="/newAdd">Add New!</a>
        <a href="/topTen">Top Songs</a>
        <form action="/search" method="post">
            <input type="text" name="search" placeholder="Search Artist">
            <input type="submit" value="Search Artists"><br><br>
        </form>
        
        
        <table border=1px>
            <tr>
                <th>Title</th>
                <th>Artist</th>
                <th>Rating</th>
                <th>Actions</th>
            </tr>
          <c:forEach items="${lookify}" var = "lookify">  
              <tr>
                <td><a href="/display/${lookify.id}">${lookify.title}</a></td>
                <td>${lookify.artist}</td>
                <td>${lookify.rating}</td>
                <td><a href="/delete/${lookify.id}">delete</a></td>
            </tr>
        </c:forEach> 
        </table>
        

	</body>
</html>