<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Distance</title>
</head>
<body>
	<p>Hello World !</p>
	<br />
	<form method="post">
		<div>
			<select name="ville1" id="ville1" size="10">

				<c:forEach var="i" begin="1" end="${listeVille.size() - 1}">
					<option
						value="${listeVille.get(i).getCoord().getLatitude()};${listeVille.get(i).getCoord().getLongitude()};${listeVille.get(i).getNom()}"><c:out
							value="${listeVille.get(i).getNom()}" /></option>
				</c:forEach>
			</select>
			<select name="ville2" id="ville2" size="10">

				<c:forEach var="i" begin="1" end="${listeVille.size() - 1}">
					<option
						value="${listeVille.get(i).getCoord().getLatitude()};${listeVille.get(i).getCoord().getLongitude()};${listeVille.get(i).getNom()}"><c:out
							value="${listeVille.get(i).getNom()}" /></option>
				</c:forEach>
			</select>
			<br />
		</div>
		<div>
			<input type="submit" value="Distance" />
		</div>
	</form>
	<br />
<%-- 	<c:out value="${distance}" /> --%>
	
</body>
</html>