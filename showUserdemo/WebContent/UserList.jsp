<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHOW</title>
<style type="text/css">
 	table{
 		margin: auto;
	 	border-collapse: collapse;
	 	display: flex;
 	}
 	table th {
 		background-color: #3a6070;
	 	color:#FFF;
	 	padding: 4px,30px,4px,8px;
 		text-align: left;
 	}
 	table td {
 		border: 1px solid #e3e3e3;
 		padding: 4px,8px;
 	}
 	table tr:nth-child(odd) td {
 		background-color: #e7edf0;
 	}
</style>
</head>
<body>
	<table>
			<tr>
				<th>username</th>
				<th>password</th>
			</tr>


			<c:forEach var="item" items="${list}" >
				<tr>
					<td>${item.username}</td>
					<td>${item.password}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>