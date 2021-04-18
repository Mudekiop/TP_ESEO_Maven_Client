<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Distance</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Distance entre deux villes :</h1>
	<br />
	<form method="post">
		<div class='liste'>
			<select name="ville1" id="ville1" size="10">

				<c:forEach var="i" varStatus="status" begin="1"
					end="${listeVille.size() - 1}">
					<c:choose>
						<c:when test="${ status.first }">
							<option selected="yes"
								value="${listeVille.get(i).getCoord().getLatitude()};${listeVille.get(i).getCoord().getLongitude()};${listeVille.get(i).getNom()}"><c:out
									value="${listeVille.get(i).getNom()}" /></option>
						</c:when>
						<c:when test="${ listeVille.get(i).getNom()==selection1 }">
							<option selected="yes"
								value="${listeVille.get(i).getCoord().getLatitude()};${listeVille.get(i).getCoord().getLongitude()};${listeVille.get(i).getNom()}"><c:out
									value="${listeVille.get(i).getNom()}" /></option>
						</c:when>
						<c:otherwise>
							<option
								value="${listeVille.get(i).getCoord().getLatitude()};${listeVille.get(i).getCoord().getLongitude()};${listeVille.get(i).getNom()}"><c:out
									value="${listeVille.get(i).getNom()}" /></option>
						</c:otherwise>
					</c:choose>

				</c:forEach>
		</div>
		<div class='liste'>
			</select> <select name="ville2" id="ville2" size="10">

				<c:forEach var="i" varStatus="status" begin="1"
					end="${listeVille.size() - 1}">
					<c:choose>
						<c:when test="${ status.first }">
							<option selected="yes"
								value="${listeVille.get(i).getCoord().getLatitude()};${listeVille.get(i).getCoord().getLongitude()};${listeVille.get(i).getNom()}"><c:out
									value="${listeVille.get(i).getNom()}" /></option>
						</c:when>
						<c:when test="${ listeVille.get(i).getNom()==selection2 }">
							<option selected="yes"
								value="${listeVille.get(i).getCoord().getLatitude()};${listeVille.get(i).getCoord().getLongitude()};${listeVille.get(i).getNom()}"><c:out
									value="${listeVille.get(i).getNom()}" /></option>
						</c:when>
						<c:otherwise>
							<option
								value="${listeVille.get(i).getCoord().getLatitude()};${listeVille.get(i).getCoord().getLongitude()};${listeVille.get(i).getNom()}"><c:out
									value="${listeVille.get(i).getNom()}" /></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
		<div>
			<input type="submit" value="Distance" class='submit'/> <a
				href='/ESEO_TP_Client/listeVilles?page=1' class='submit'> Liste des villes </a> <br />
			<c:out value="${distance}"/>
		</div>
	</form>

</body>
</html>